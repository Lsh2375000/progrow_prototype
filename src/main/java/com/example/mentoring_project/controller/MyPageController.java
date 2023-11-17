package com.example.mentoring_project.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myPage")
@Log4j2
@RequiredArgsConstructor
public class MyPageController {

    @GetMapping("/mentor")
    public void mentorMyPageGET() {
        log.info("mentorMyPageGET() ...");
    }

    @PostMapping("/mentor")
    public void mentorMyPagePOST() {
        log.info("mentorMyPagePOST() ...");
    }


    @GetMapping("/mentee")
    public void menteeMyPageGET() {
        log.info("menteeMyPageGET() ...");
    }

    @PostMapping("/mentee")
    public void menteeMyPagePOST() {
        log.info("menteeMyPagePOST() ...");
    }


}
