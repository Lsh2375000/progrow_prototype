package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.MemberDTO;
import com.example.mentoring_project.service.MailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MailController {

    private final MailSenderService mailSenderService;

    @GetMapping("/sendConfirmMail")
    @ResponseBody
    public String sendConfirmMail(String mailTo, HttpSession session) throws Exception {
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

    @PostMapping("/isConfirmKey")
    @ResponseBody
    public boolean isConfirmKey (HttpSession session, String confirmKey) throws Exception {
        log.info("isConfirmKey......");
        String isConfirmKey =  (String) session.getAttribute("confirmKey"); // 변수를 세션에 저장
        log.info(isConfirmKey);
        log.info(confirmKey);
        if (confirmKey.equals(isConfirmKey)) {
            return true;

        } else {
            return false;
        }
    }
}