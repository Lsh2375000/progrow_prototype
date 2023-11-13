package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MenteeRegisterVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Log4j2
class MenteeRegisterMapperTests {
    @Autowired
    private MenteeRegisterMapper menteeRegisterMapper;

    @Test
    public void insertTest() {
        for (int i = 1; i < 11; i++) {
            MenteeRegisterVO menteeRegisterVO = MenteeRegisterVO.builder()
                    .mentee_id("멘티Test" + i)
                    .passwd("1234" + i)
                    .name("mentee" + i)
                    .region("서울시 강남구 도곡동" + i)
                    .age(10 + i)
                    .nickname("멘티Nick" + i)
                    .lngName("Java" + i)
                    .type("tee")
                    .build();
            menteeRegisterMapper.insert(menteeRegisterVO);
        }
    }

    @Test
    public void testSelectAll() {
        List<MenteeRegisterVO> voList = menteeRegisterMapper.selectAll();
        voList.forEach(log::info);
    }

    @Test
    public void selectOneTest() {
        log.info(menteeRegisterMapper.selectOne(2L));
    }

    @Test
    public void updateTest() {
        MenteeRegisterVO menteeRegisterVO = MenteeRegisterVO.builder()
                .menteeNo(10L)
                .mentee_id("멘티TestUp")
                .passwd("0000")
                .name("멘티NameUp")
                .region("서울시 성동구 행당동")
                .age(10)
                .nickname("멘티NickUp")
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