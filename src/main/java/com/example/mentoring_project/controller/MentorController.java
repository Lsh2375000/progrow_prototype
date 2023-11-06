package com.example.mentoring_project.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mentor")
@Log4j2
@RequiredArgsConstructor
public class MentorController {

    @GetMapping("/main")
    public void mentorMain() {

    }
}
