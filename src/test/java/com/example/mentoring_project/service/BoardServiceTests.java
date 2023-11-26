//package com.example.mentoring_project.service;
//
//import com.example.mentoring_project.dto.BoardDTO;
//import com.example.mentoring_project.mapper.BoardMapper;
//import lombok.extern.log4j.Log4j2;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@Log4j2
//@SpringBootTest
//public class BoardServiceTests {
//    @Autowired
//    private BoardService boardService;
//
//    @Autowired
//    private BoardMapper boardMapper;
//
//    @Test
//    public void addTest(){
//        BoardDTO boardDTO = BoardDTO.builder()
//                .id("TestUser")
//                .writer("User")
//                .hit(20)
//                .content("제발 좀 되라")
//                .title("최악").build();
//        boardService.register(boardDTO, files);
//    }
//
//
//
//    /*전체 삭제 테스트 코드(완)*/
//    @Test
//    void deleteOneTest(){
//        Long boardNo = 710L;
//        boardService.deleteOne(boardNo);
//    }
//
//    @Test
//    public void updateTest(){
//        Long boardNo = 1L;
//        BoardDTO boardDTO = BoardDTO.builder()
//                .boardNo(boardNo)
//                .title("MEMO")
//                .content("JAVA")
//                .build();
//    }
//
//
//}

