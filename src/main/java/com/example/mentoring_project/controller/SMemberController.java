package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.MemberJoinDTO;
import com.example.mentoring_project.dto.MenteeDTO;
import com.example.mentoring_project.dto.MentorDTO;
import com.example.mentoring_project.service.MenteeService;
import com.example.mentoring_project.service.MentorService;
import com.example.mentoring_project.service.SMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class SMemberController {

    private final SMemberService sMemberService;
    private final MenteeService menteeService;
    private final MentorService mentorService;

    private final ModelMapper modelMapper;

    private final HttpSession session;

    // 로그인
    @GetMapping("/login")
    public void login(String error, String logout) {
        log.info("login get....");
        log.info("logout : " + logout);

        if (logout != null) {
            log.info("user logout....");
        }
    }

    // 회원 가입 약관동의
    @GetMapping("/agreement")
    public void memberAgree() {
        log.info("/member/agreement");
    }

    // 멘티 회원가입 시작
    @GetMapping("/menteeRegister")
    public void getMentee(Model model, MentorDTO mentorDTO) {
        log.info("/member/menteeRegister......");
        String isConfirmKey = (String) session.getAttribute("confirmKey");
        log.info("confirmKey: " + isConfirmKey);

    }

    //멘토 회원가입 시작
    @GetMapping("/mentorRegister")
    public void getMentor() {
        log.info("/member/mentorRegister......");
        String isConfirmKey = (String) session.getAttribute("confirmKey");
        log.info("confirmKey: " + isConfirmKey);
    }

    // type필터로 받은 정보를 확인해서 각 DB로 넣어준다.
    @PostMapping("/register")
    public String addMentor(MentorDTO mentorDTO, MenteeDTO menteeDTO, HttpServletRequest request) {
        log.info("/register...");

        String referer = (String)request.getHeader("REFERER"); // 이전의 URL경로를 들고 온다
        log.info("backHistory........." + referer);

        String torRegisterURL = "http://localhost:8080/member/mentorRegister"; // 멘토 회원가입 주소
        String teeRegisterURL = "http://localhost:8080/member/menteeRegister"; // 멘티 회원가입 주소


        if (referer.equals(torRegisterURL)){ // URL : /member/mentorRegister
            log.info("TYPE : TOR.....");
            mentorDTO.setType("tor");
            MemberJoinDTO memberJoinDTO = MemberJoinDTO.builder()
                            .mid(mentorDTO.getMentor_id())
                            .mpw(mentorDTO.getPasswd())
                            .del(false)
                            .social(false)
                            .type(mentorDTO.getType())
                            .build();
            log.info(mentorDTO);
            mentorService.add(mentorDTO);
            sMemberService.add(memberJoinDTO);
        } else if (referer.equals(teeRegisterURL)) { // URL : /member/menteeRegister
            log.info("TYPE : TEE.....");
            menteeDTO.setType("tee");
            MemberJoinDTO memberJoinDTO = MemberJoinDTO.builder()
                            .mid(menteeDTO.getMentee_id())
                            .mpw(menteeDTO.getPasswd())
                            .del(false)
                            .social(false)
                            .type(menteeDTO.getType())
                            .build();
            log.info(menteeDTO);
            sMemberService.add(memberJoinDTO);
            menteeService.add(menteeDTO);
        }


        return "redirect:/member/login";
    }


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/modify/{mid}")
    public String modifyGET(@PathVariable("mid") String mid, Model model) {
        log.info("modify get...");
        model.addAttribute("mid", mid);
        return "/member/modify";
    }

    @PostMapping("/modify")
    public String modifyPOST(String mid, String mpw, RedirectAttributes redirectAttributes) {
        log.info("modify post...");
        sMemberService.modifyPassword(mpw, mid);

        return "redirect:/mentoring/main";
    }

}
