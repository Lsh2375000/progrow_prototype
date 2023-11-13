package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.MenteeRegisterDTO;
import com.example.mentoring_project.service.MenteeRegisterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MenteeRegisterController {
    private final MenteeRegisterService menteeRegisterService;

    @GetMapping("/menteeRegister")
    public void menteeRegister() {
        log.info("멘티 회원가입");

    }

    @PostMapping("/menteeRegister")
    public String menteeRegister(MenteeRegisterDTO menteeRegisterDTO) {
        menteeRegisterService.add(menteeRegisterDTO);
        return "redirect:/member/login";

    }
//try {
//        // 여기서 회원가입 로직을 수행하고 결과를 모델에 추가하거나 필요에 따라 다른 작업을 수행할 수 있습니다.
//        menteeRegisterService.add(menteeRegisterDTO);
//
//        // 회원가입이 성공했다면 어떤 페이지로 이동할지를 리턴합니다.
//        return "redirect:/member/login";
//    } catch (Exception e) {
//        // 예외가 발생했을 경우 로깅하고 에러 페이지로 이동하도록 할 수 있습니다.
//        log.error("Error during mentee registration", e);
//        model.addAttribute("error", "회원가입 중 오류가 발생했습니다.");
//        return "error";
//    }
}