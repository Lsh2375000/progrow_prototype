package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.QReplyDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class QReplyServiceImplTests {
    @Autowired
    private QReplyService qReplyService;

    @Test
    public void testRegister() {
        QReplyDTO qReplyDTO = QReplyDTO.builder()
                .id("qReplytt")
                .qBoardNo(1L)
                .nickName("작성자")
                .qReply("댓글내용")
                .qRno(202L)
                .build();
        log.info(qReplyService.register(qReplyDTO));
    }

    @Test
    public void testRead() {
        log.info(qReplyService.read(2L));
    }

    @Test
    public void testModify() {
        QReplyDTO qReplyDTO = QReplyDTO.builder()
                .qRno(2L)
                .qReply("댓글수정")
                .build();
        qReplyService.modify(qReplyDTO);
    }

    @Test
    public void testDelete() {
        qReplyService.remove(200L);
    }

    @Test
    public void testGetListOfBoard() {
        qReplyService.getListOfBoard(105L, PageRequestDTO.builder().build());
    }
}