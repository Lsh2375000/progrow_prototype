package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.qBoardVO.QBoardVO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.mapper.qBoardMapper.QBoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class QBoardMapperTests {
    @Autowired
    private QBoardMapper qBoardMapper;

    /*게시글 추가 테스트 코드(완)*/
    @Test
    public void addTest(){
        QBoardVO qBoardVO = QBoardVO.builder()
                .id("TT")
                .hit(12)
                .nickName("TY")
                .content("Test...Content...")
                .title("Test...ing")
                .build();
        qBoardMapper.insert(qBoardVO);
    }

    /*게시판 데이터 넣은 테스트 코드*/
    @Test
    void insert(){
        for (int i = 1; i <= 200; i++){
            QBoardVO qBoardVO = QBoardVO.builder()
                    .id("TestString" + (i % 10))
                    .hit(11 + i)
                    .nickName("Pro" + i)
                    .content("Insert...Content..TEST...")
                    .title("TitleTest")
                    .build();
            qBoardMapper.insert(qBoardVO);
        }
    }


    @Test
    public void testSelectList() {
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(2)
                .build();
        qBoardMapper.selectList(pageRequestDTO).forEach(log::info);
        log.info(qBoardMapper.getCount(pageRequestDTO));
    }

    @Test
    void modify() {
    }

    @Test
    void delete() {
        Long qBoardNo = 1L;

//        qBoardMapper.delete(qBoardNo);
    }

    @Test
    void updateHit() {
    }

    @Test
    void selectList() {
    }

    @Test
    void getCount() {
    }





}


