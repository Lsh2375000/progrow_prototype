package com.example.mentoring_project.repository;

import com.example.mentoring_project.domain.BoardVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testSelect(){
        Long boardNo = 1L;
        Optional<BoardVO> result = boardRepository.findById(boardNo);
        BoardVO boardVO = result.orElseThrow();
        log.info(boardVO);
    }


}
