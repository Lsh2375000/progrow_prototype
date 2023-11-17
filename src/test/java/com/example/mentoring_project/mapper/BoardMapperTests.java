package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.dto.BoardDTO;
import com.example.mentoring_project.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardService boardService;

    /*게시글 추가 테스트 코드(완)*/
    @Test
    public void addTest(){
        BoardVO boardVO = BoardVO.builder()
                .id("TT")
                .hit(12)
                .content("Test...Content...")
                .title("Test...ing")
                .build();
        boardMapper.insert(boardVO);
    }

    /*게시판 데이터 넣은 테스트 코드*/
    @Test
    void insert(){
        for (int i = 1; i <= 100; i++){
            BoardVO boardVO = BoardVO.builder()
                    .id("TestString" + (i % 10))
                    .hit(11 + i)
                    .content("Insert...Content..TEST...")
                    .title("TitleTest")
                    .build();
            boardMapper.insert(boardVO);
        }
    }

    @Test
    public void testModify(){
        BoardDTO boardDTO = BoardDTO.builder()
                .boardNo(10L)
                .title("Modify")
                .content("Modify...Test")
                .build();
        boardService.modify(boardDTO);
    }





    }


