//package com.example.mentoring_project.mapper;
//
//import com.example.mentoring_project.domain.boardVO.BoardVO;
//import com.example.mentoring_project.service.boardService.BoardService;
//import lombok.extern.log4j.Log4j2;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.UUID;
//
//@SpringBootTest
//@Log4j2
//public class BoardMapperTests {
//    @Autowired
//    private BoardMapper boardMapper;
//
//    @Autowired
//    private BoardService boardService;
//
////    /*게시글 추가 테스트 코드(완)*/
////    @Test
////    public void addTest(){
////        BoardVO boardVO = BoardVO.builder()
////                .id("TT")
////                .hit(12)
////                .content("Test...Content...")
////                .title("Test...ing")
////                .build();
////        boardMapper.register(boardVO);
////    }
//
//    /*게시판 데이터 넣은 테스트 코드*/
//    @Test
//    void insert(){
//        for (int i = 1; i <= 100; i++){
//            BoardVO boardVO = BoardVO.builder()
//                    .id("TestString" + (i % 10))
//                    .nickName("User1" + (i % 10))
//                    .hit(11 + i)
//                    .content("Insert...Content..TEST...")
//                    .title("TitleTest")
//                    .build();
//            boardMapper.save(boardVO);
//        }
//    }
//
//    @Test
//    void deleteOneTest(){
//        Long boardNo = 710L;
//        boardService.deleteOne(boardNo);
//    }
//
//    /*첨부파일이 있는 게시물 등록 서비스(성공)*/
//    @Test
//    public void insertWithImages(){
//        BoardVO boardVO = BoardVO.builder()
//                .title("Image test")
//                .content("첨부파일 테스트")
//                .id("user00")
//                .nickName("tester").
//                build();
//        for (int i = 0; i < 3; i++){
//            boardVO.addImage(UUID.randomUUID().toString(), "file" + i + ".jpg");
//        }
//        boardMapper.save(boardVO);
//    }
//
//
//
//
//    }


