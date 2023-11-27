package com.example.mentoring_project.mapper;


import com.example.mentoring_project.dto.replyDTO.ReplyDTO;
import com.example.mentoring_project.service.replyService.ReplyService;
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
                .boardNo(149L)
                .replyText("TEST")
                .replyWriter("User")
                .build();
        replyService.register(replyDTO);
    }




}
