package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.memberVO.SMemberVO;
import com.example.mentoring_project.mapper.memberMapper.SMemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Log4j2
public class SMemberMapperTests {

    @Autowired
    private SMemberMapper sMemberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void addMemberTest() { // 일반 회원가입
        SMemberVO sMemberVO = SMemberVO.builder()
                .mid("test2")
                .mpw("1111")
                .del(false)
                .type("tor")
                .social(false)
                .build();
        sMemberMapper.addMember(sMemberVO);
        sMemberMapper.addMemberRole(sMemberVO.getMid(), 0); // 멤버롤 지정
    }



    @Test
    public void getMemberIdTest() { // 회원 이메일 찾기
        log.info(sMemberMapper.getMemberId("member1"));
    }

    @Test
    public void updatePassword() { // 비밀번호 변경

        log.info(sMemberMapper.getMemberId("zaqxsw3275@naver.com"));
        passwordEncoder = new BCryptPasswordEncoder();
        sMemberMapper.updatePassword(passwordEncoder.encode("qwdfwe159*"), "zaqxsw3275@naver.com");

        log.info(sMemberMapper.getMemberId("zaqxsw3275@naver.com"));


    }

    @Test
    public void getMemberId() {
        log.info(sMemberMapper.getMemberId("member1"));
    }

    @Test
    public void getMemberNickname() {
        log.info(sMemberMapper.getMemberNickname("test1"));
    }



}
