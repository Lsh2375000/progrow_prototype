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
                .writer("User")
                .hit(20)
                .content("제발 좀 되라")
                .title("최악").build();
        boardService.register(boardDTO);
    }



    /*전체 삭제 테스트 코드(완)*/
    @Test
    void deleteOneTest(){
        Long boardNo = 710L;
        boardService.deleteOne(boardNo);
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

    @Test
    public void testRegister(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("Java Test...")
                .content("Test..")
                .id("user00")
                .writer("Hello")
                .build();
        Long boardNo = boardService.register(boardDTO);

        log.info("boardNo: " + boardNo);
    }



}
