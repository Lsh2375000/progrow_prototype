package com.example.mentoring_project.controller;

import com.example.mentoring_project.service.MailSendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/login")
    public void login() {

    }

    private final MailSendService mailSendService;

    @GetMapping("/sendConfirmMail")
    @ResponseBody
    public String sendConfirmMail (String mailTo, HttpSession session) throws Exception {
        if (mailSendService.sendMailByAddMember(mailTo)) {
            session.setAttribute("confirmKey", mailSendService.getConfirmKey());
            return "true";
        }
        else {
            return "false";
        }
    }
}
