package com.example.mentoring_project.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class ReplyServiceImplTests {
    @Autowired
    private ReplyService ReplyService;

//    @Test
//    public void addTest() {
//        ReplyVO replyVO = ReplyVO.builder()
//                .boardNo(149L)
//                .replyWriter("User")
//                .replyText("Test")
//                .rno(2L)
//                .build();
//        ReplyService.register(ReplyDTO);
//    }
}