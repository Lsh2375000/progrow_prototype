package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MenteeRegisterVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Log4j2
class MenteeRegisterMapperTests {
    @Autowired
    private MenteeRegisterMapper menteeRegisterMapper;

    @Test
    public void insertTest() {
        for (int i = 1; i < 11; i++) {
            MenteeRegisterVO menteeRegisterVO = MenteeRegisterVO.builder()
                    .mentee_id("menteeTest" + i)
                    .passwd("1234" + i)
                    .name("menteeName" + i)
                    .region("서울시 강남구 도곡동" + i)
                    .age(10 + i)
                    .nickname("menteeNick" + i)
                    .lngName("Java" + i)
                    .type("tee")
                    .build();
            menteeRegisterMapper.insert(menteeRegisterVO);
        }
    }

    @Test
    public void selectOneTest() {
        log.info(menteeRegisterMapper.selectOne(2L));
    }

    @Test
    public void updateTest() {
        MenteeRegisterVO menteeRegisterVO = MenteeRegisterVO.builder()
                .mentee_id("menteeTestUp")
                .passwd("0000")
                .name("menteeNameUp")
                .region("서울시 성동구 행당동")
                .age(10)
                .nickname("meneeTestNickUp")
                .lngName("Python")
                .type("tee")
                .build();
        menteeRegisterMapper.update(menteeRegisterVO);
    }

    @Test
    public void deleteTest() {
        menteeRegisterMapper.delete(10L);
    }

}