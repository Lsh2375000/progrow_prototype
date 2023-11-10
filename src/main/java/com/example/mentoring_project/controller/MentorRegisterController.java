//package com.example.mentoring_project.controller;
//
//import com.example.mentoring_project.service.MentorRegisterService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/member/mentorRegister")
//@Log4j2
//@RequiredArgsConstructor
//public class MentorRegisterController {
//    @Value("${com.example.mentoring_project.upload.path}") // 파일 업, 다운로드 처리 위해 어노테이션 추가
//    private String uploadPath;
//
//    @Autowired
//    private final MentorRegisterService mentorRegisterService;
//
//
//}