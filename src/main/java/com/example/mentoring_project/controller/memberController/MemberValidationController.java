package com.example.mentoring_project.controller.memberController;

import com.example.mentoring_project.dto.memberDTO.MemberSecurityDTO;
import com.example.mentoring_project.service.mailService.MailSenderService;
import com.example.mentoring_project.service.memberService.SMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberValidationController {
    private final SMemberService sMemberService;
    private final MailSenderService mailSenderService;

    @GetMapping("/sendConfirmMail")
    @ResponseBody
    public String sendConfirmMail(String mailTo, HttpSession session) throws Exception { // 인증문자 전송
        if (mailSenderService.sendMailByAddMember(mailTo)) {
            String confirmKey = mailSenderService.getConfirmKey(); // 인증문자를 변수에 저장
            session.setAttribute("confirmKey", confirmKey); // 변수를 세션에 저장
            session.setAttribute("inputEmail", mailTo); // 입력한 이메일을 세션에 저장
            log.info("입력한 이메일 : "+ mailTo);
            log.info("인증문자 :" + confirmKey); // 변수를 로그에 출력

            return "true";
        }
        else {
            return "false";
        }
    }

    @PostMapping("/matchConfirmKey")
    @ResponseBody
    public String  matchConfirmKey(HttpSession session, String confirmKey) throws Exception { // 입력한 인증문자 확인
        log.info("matchConfirmKey......");
        String matchConfirmKey =  (String) session.getAttribute("confirmKey"); // 변수에 세션값을 저장
        log.info(matchConfirmKey);
        log.info(confirmKey);
        if (confirmKey.equals(matchConfirmKey)) {
            session.setAttribute("isEmail", true); // 맞는 인증문자를 입력했다면 true를 세션에 담아준다.
            return "true";
        } else {
            return "false";
        }
    }

    // 회원 가입 약관동의
    @GetMapping("/agreement")
    public void memberAgree() {
        log.info("/member/agreement");
    }


    @PostMapping("/isEmail")
    @ResponseBody
    public String isEmail(@RequestParam String email, HttpSession session) { // 이메일 존재 유무
        log.info("idCheck......");
        log.info(email);

        if (sMemberService.getMemberId(email) != null) {
            log.info("null.....");
            session.setAttribute("email", email);
            return "ture";
        }
        return "false";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public String idCheck(@RequestParam String mentee_id, HttpSession session) { // 이메일 중복 체크
        log.info("idCheck......");
        log.info(mentee_id);
        if (sMemberService.getMemberId(mentee_id) == null) {
            log.info("null.....");
            return "true";
        }
        return "false";
    }

    @PostMapping("/nicknameCheck")
    @ResponseBody
    public String nicknameCheck(@RequestParam String nickname, HttpSession session) { // 닉네임 중복 체크
        log.info("nicknameCheck......");
        log.info("입력한 이메일 : " + nickname);
        session.setAttribute("inputNickname", nickname); // 닉네임을 세션에 담는다
        if (sMemberService.getMemberNickname(nickname) == null) {
            log.info("null.....");
            return "true";
        }
        return "false";
    }

    @PostMapping("/passwordCheck")
    @ResponseBody
    public String passwordCheck(@AuthenticationPrincipal MemberSecurityDTO memberSecurityDTO, @RequestParam String inputPw) { // 현재 비밀번호 체크
        log.info("passwordCheck...");
        log.info(memberSecurityDTO);
        String encodePw = memberSecurityDTO.getMpw();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(inputPw, encodePw)) {
            return "true";
        }
        return "false";
    }

    // 회원가입전 마지막 체크
    @PostMapping("/lastCheck")
    @ResponseBody
    public String lastCheck(HttpSession session, String inputEmail, String inputNickname) {

        String okInputEmail = (String) session.getAttribute("inputEmail");
        String okInputNickname = (String) session.getAttribute("inputNickname");

        log.info("중복 검사로 확인된 값 : " + okInputNickname + ", " + okInputEmail);
        log.info("마지막에 버튼 눌렀을 때 확인 된 값 : " + inputEmail + ", " + inputNickname);

        if (!okInputEmail.equals(inputEmail) ||
                sMemberService.getMemberId(inputEmail ) != null) {
            // 1. 중복검사할 때 이메일 값과 회원가입 눌렀을 때 이메일 값이 다르거나
            // 2. 회원가입 버튼눌렀을 때 입력된 이메일의 정보가 이미 존재한다면

            log.info("이메일 중복검사 재실행!!");
            session.removeAttribute("inputEmail");
            // 세션에 담긴 값과 입력한값이 다르면
            return "emailFalse";

        } else if (!okInputNickname.equals(inputNickname) ||
                sMemberService.getMemberNickname(inputNickname) != null) {
            // 1. 중복검사할 때 닉네임 값과 회원가입 눌렀을 때 이메일 값이 다르거나
            // 2. 회원가입 버튼눌렀을 때 입력된 닉네임의 정보가 이미 존재한다면

            log.info("닉네임 중복 검사 재실행!!");
            session.removeAttribute("inputNickname");
            return "nicknameFalse";
        }

        return "true";
    }


    @PostMapping("/lastModifyCheck")
    @ResponseBody
    public String lastModifyCheck(HttpSession session, String inputNickname) { // 회원 수정전 마지막 체크
        String okInputNickname = (String) session.getAttribute("inputNickname");

        log.info("중복 검사로 확인된 값 : " + okInputNickname);
        log.info("마지막에 버튼 눌렀을 때 확인 된 값 : " + inputNickname);

        if (!okInputNickname.equals(inputNickname) ||
                sMemberService.getMemberNickname(inputNickname) != null) {
            log.info("닉네임 중복 검사 재실행!!");
            return "false";
        }
        return "ture";
    }
}
