package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.SMemberVO;
import com.example.mentoring_project.dto.MemberJoinDTO;
import com.example.mentoring_project.mapper.SMemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Log4j2
public class SMemberServiceTest {

    @Autowired(required = false)
    private SMemberService sMemberService;

    private PasswordEncoder passwordEncoder;


    @Test
    public void addMemberTest() {
        passwordEncoder = new BCryptPasswordEncoder();
        String mid = "member1";
        MemberJoinDTO memberJoinDTO = MemberJoinDTO.builder()
                .mid(mid)
                .mpw(passwordEncoder.encode("1111"))
//                .email("mem@ber.com")
                .del(false)
                .social(false).build();
        sMemberService.add(memberJoinDTO);
    }


    @Test
    public void getOneTest() {
        String email = "zaqxsw3276@naver.com";
        log.info(sMemberService.getMemberId(email).getType());

    }



}