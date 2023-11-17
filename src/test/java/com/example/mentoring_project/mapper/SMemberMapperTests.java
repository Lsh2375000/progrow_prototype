package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.SMemberVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class SMemberMapperTests {

    @Autowired
    private SMemberMapper sMemberMapper;

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
    public void getMemberIdTest() { // 회원 아이디 찾기
        log.info(sMemberMapper.getMemberId("member1"));
    }

    @Test
    public void updatePassword() { // 비밀번호 변경

        log.info(sMemberMapper.getMemberId("test1"));

        sMemberMapper.updatePassword("5555", "test1");

        log.info(sMemberMapper.getMemberId("test1"));


    }


//    @Test
//    public void findByEmail() {
//        log.info(sMemberMapper.findByEmail("mem@ber.com"));
//    }
}
