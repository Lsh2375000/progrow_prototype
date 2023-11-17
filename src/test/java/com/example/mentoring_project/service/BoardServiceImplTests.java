package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.BoardDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class BoardServiceImplTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void addTest(){
        BoardDTO boardDTO = BoardDTO.builder()
                .id("TestUser")
                .hit(20)
                .content("제발 좀 되라")
                .title("최악").build();
        boardService.add(boardDTO);
    }



    /*전체 삭제 테스트 코드(완)*/
    @Test
    public void deleteTest(){
        Long boardNo = 1L;
        boardService.delete(boardNo);
    }

    @Test
    public void updateTest(){
        Long boardNo = 1L;
        BoardDTO boardDTO = BoardDTO.builder()
                .boardNo(boardNo)
                .title("MEMO")
                .content("JAVA")
                .build();
    }




}
