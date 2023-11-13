package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.BoardVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

    /*게시글 추가 테스트 코드(완)*/
    @Test
    public void addTest(){
        BoardVO boardVO = BoardVO.builder()
                .id("TT")
                .hit(12)
                .nickName("TY")
                .content("Test...Content...")
                .title("Test...ing")
                .build();
        boardMapper.insert(boardVO);
    }

    /*게시판 데이터 넣은 테스트 코드*/
    @Test
    void insert(){
        for (int i = 1; i <= 200; i++){
            BoardVO boardVO = BoardVO.builder()
                    .id("TestString" + (i % 10))
                    .hit(11 + i)
                    .nickName("Pro" + i)
                    .content("Insert...Content..TEST...")
                    .title("TitleTest")
                    .build();
            boardMapper.insert(boardVO);
        }
    }

    /*게시글 수정 테스트 코드*/





    }

