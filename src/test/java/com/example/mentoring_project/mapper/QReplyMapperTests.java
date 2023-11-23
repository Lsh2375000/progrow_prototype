package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.QReplyVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Log4j2
public class QReplyMapperTests {
    @Autowired
    private QReplyMapper qReplyMapper;

    /*게시글 추가 테스트 코드(완)*/
    @Test
    public void insertQnaTest(){
        QReplyVO qReplyVO = QReplyVO.builder()
                .qBoardNo(600L)
                .id("qReTest")
                .nickName("TY")
                .qReply("Test...Content...")
                .build();
        qReplyMapper.insertQR(qReplyVO);
    }

    /*댓글 데이터 넣은 테스트 코드*/
    @Test
    void insertQnaRoop(){
        for (int i = 1; i <= 200; i++){
            QReplyVO qReplyVO = QReplyVO.builder()
                    .qBoardNo(600L)
                    .nickName("Pro" + i)
                    .id("qReTest" + i)
                    .qReply("Insert...Content..TEST...")
                    .build();
            qReplyMapper.insertQR(qReplyVO);
        }
    }


//    @Test
//    public void testSelectOne() {
////        log.info(QReplyMapper.update(5L));
//        //log.info(QBoardMapper.selectOne(2L));
//    }

    @Test
    public void testDelete() {
        qReplyMapper.deleteQR(201L);
    }

    @Test
    public void testUpdate() {
        QReplyVO qReplyVO = QReplyVO.builder()
                .nickName("이름 수정")
                .qRno(5L)
                .qReply("내용 수정")
                .build();
        qReplyMapper.updateQR(qReplyVO);
    }






}


