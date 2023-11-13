package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MentoringVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
@Log4j2
public class MentoringMapperTests {

    @Autowired
    private MentoringMapper mentoringMapper;

    @Test
    public void insertTest() {
        MentoringVO mentoringVO = MentoringVO.builder()
                .id("test")
                .maxNumPeople(3)
                .menteeNum(2)
                .region("대구")
                .lngName("JAVA")
                .meeting(true)
                .on_off(true)
                .build();
        mentoringMapper.insert(mentoringVO);

    }

}
