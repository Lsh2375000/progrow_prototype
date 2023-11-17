package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.BoardDTO;
import com.example.mentoring_project.dto.QBoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class QBoardServiceImplTests {
    @Autowired
    private QBoardService qBoardService;

    @Test
    public void addTest(){
        QBoardDTO qBoardDTO = QBoardDTO.builder()
                .id("TestUser")
                .hit(20)
                .nickName("User")
                .content("제발 좀 되라")
                .title("테스트중").build();
        qBoardService.add(qBoardDTO);
    }



    /*전체 삭제 테스트 코드(완)*/
    @Test
    public void deleteTest(){
        Long qBoardNo = 1L;
        qBoardService.delete(qBoardNo);
    }

    @Test
    public void updateTest(){
        Long qBoardNo = 1L;
        QBoardDTO qBoardDTO = QBoardDTO.builder()
                .qBoardNo(qBoardNo)
                .title("MEMO")
                .content("JAVA")
                .build();
    }
}
