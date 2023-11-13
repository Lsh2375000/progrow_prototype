package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.MemberDTO;
import com.example.mentoring_project.dto.MenteeDTO;
import com.example.mentoring_project.dto.MentorDTO;
import com.example.mentoring_project.service.MailSenderService;
import com.example.mentoring_project.service.MemberService;
import com.example.mentoring_project.service.MenteeService;
import com.example.mentoring_project.service.MentorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MenteeService menteeService;
    private final MentorService mentorService;
    private final MemberService memberService;
    private final ModelMapper modelMapper;

    private final MailSenderService mailSenderService;
    private final HttpSession session;

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/memberAgree")
    public void memberAgree() {
        log.info("/member/memberAgree");
    }

    @GetMapping("/menteeRegister")
    public void getMentee(Model model) {
        log.info("/member/menteeRegister......");

        String isConfirmKey = (String) session.getAttribute("confirmKey");
        log.info("confirmKey: " + isConfirmKey);
        model.addAttribute("confirmKey", isConfirmKey); // Model 객체에 세션값 추가

//        if (isConfirmKey == mailSenderService.getConfirmKey()) {
//            return true;
//        } else {
//            return false;
        }



    @PostMapping("/menteeRegister")
    public String addMentee(MenteeDTO menteeDTO, String type) { // 멘티 회원 추가 - 추가될때 자동으로 member테이블로 넘어감
        log.info("/member/addMentee...");
        log.info(menteeDTO);

        MemberDTO memberDTO = modelMapper.map(menteeDTO, MemberDTO.class);
        memberDTO.setType(type);
        memberDTO.setId(menteeDTO.getMentee_id());
        // type과 id를 따로 넣어주는 이유는 type은 기본값이고 id는 컬럼값이 다르기 떄문
        String confirmKey = (String) session.getAttribute("confirmKey");
        menteeService.add(menteeDTO);
        memberService.add(memberDTO);

        return "redirect:/mentor/main";
    }



    @GetMapping("/mentorRegister")
    public void getMentor() {


        log.info("/member/mentorRegister......");
    }

    @PostMapping("/mentorRegister")
    public String addMentor(MentorDTO mentorDTO, String type) {
        log.info("/member/addMentor...");
        log.info(mentorDTO);



        MemberDTO memberDTO = modelMapper.map(mentorDTO, MemberDTO.class);
        memberDTO.setType(type);
        memberDTO.setId(mentorDTO.getMentor_id());

        mentorService.add(mentorDTO);
        memberService.add(memberDTO);

        return "redirect:/mentor/main";
    }

}
