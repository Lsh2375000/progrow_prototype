package com.example.mentoring_project.mapper;


import com.example.mentoring_project.dto.ReplyDTO;
import com.example.mentoring_project.service.ReplyService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ReplyMapperTests {
    @Autowired
    private ReplyService replyService;

    /*리플 추가*/
    @Test
    public void addTest(){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .boardNo(1L)
                .replyText("TEST")
                .replyWriter("User")
                .build();
        replyService.insertReply(replyDTO);
    }




}
