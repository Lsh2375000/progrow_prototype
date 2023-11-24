package com.example.mentoring_project.controller.myPageController;

import com.example.mentoring_project.dto.memberDTO.MemberSecurityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
@Log4j2
@RequiredArgsConstructor
public class MyPageController {

    /*멘토 마이페이지 시작*/
    @GetMapping("/mentor")
    public String mentorMyPageGET(@AuthenticationPrincipal MemberSecurityDTO memberSecurityDTO) { // 멘토 마이페이지 GET
        log.info("mentorMyPageGET() ...");

        log.info(memberSecurityDTO.getType());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (!memberSecurityDTO.getType().equals("tor")) {
            return "redirect:/";
        }
        return "/mypage/mentor";
    }

    @PostMapping("/mentor")
    public void mentorMyPagePOST() {
        log.info("mentorMyPagePOST() ...");
    }
    /*멘토 마이페이지 끝*/
    /*멘티 마이페이지 시작*/
    @GetMapping("/mentee")
    public String menteeMyPageGET(@AuthenticationPrincipal MemberSecurityDTO memberSecurityDTO) { // 멘티 마이페이지 GET
        log.info("menteeMyPageGET() ...");

        log.info(memberSecurityDTO.getType());
        if (!memberSecurityDTO.getType().equals("tee")) {
            return "redirect:/";
        }
        return "/mypage/mentee";
    }

    @PostMapping("/mentee")
    public void menteeMyPagePOST() {
        log.info("menteeMyPagePOST() ...");
    }
    /*멘티 마이페이지 끝*/


}
