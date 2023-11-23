package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.MemberSecurityDTO;
import com.example.mentoring_project.service.MailSenderService;
import com.example.mentoring_project.service.SMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public String sendConfirmMail(String mailTo, HttpSession session) throws Exception { // 인증키 전송
        if (mailSenderService.sendMailByAddMember(mailTo)) {
            String confirmKey = mailSenderService.getConfirmKey(); // 인증키를 변수에 저장
            session.setAttribute("confirmKey", confirmKey); // 변수를 세션에 저장
            log.info("입력한 이메일 : "+ mailTo);
            log.info("인증키 :" + confirmKey); // 변수를 로그에 출력

            return "true";
        }
        else {
            return "false";
        }
    }

    @PostMapping("/matchConfirmKey")
    @ResponseBody
    public String  matchConfirmKey(HttpSession session, String confirmKey) throws Exception { // 입력한 인증키 확인
        log.info("matchConfirmKey......");
        String matchConfirmKey =  (String) session.getAttribute("confirmKey"); // 변수를 세션에 저장
        log.info(matchConfirmKey);
        log.info(confirmKey);
        if (confirmKey.equals(matchConfirmKey)) {
            session.setAttribute("isEmail", true); // 맞는 인증키를 입력했다면 true를 세션에 담아준다.
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
    public String isEmail(@RequestParam String email, HttpSession session) { // 아이디 존재 유무
        log.info("idCheck......");
        log.info(email);
        if (sMemberService.getMemberId(email) != null) {
            log.info("null.....");
            session.setAttribute("email", email); // 입력한 이메일이 존재 한다면 이메일을 세션에 담아준다.
            return "ture";
        }
        return "false";
    }

    @PostMapping("/idCheck")
    @ResponseBody
    public String idCheck(@RequestParam String mentee_id) { // 아이디 중복 체크
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
    public String nicknameCheck(@RequestParam String nickname) { // 비밀번호 중복 체크
        log.info("nicknameCheck......");
        log.info(nickname);

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
}
