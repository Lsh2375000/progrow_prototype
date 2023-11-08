package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MentoringDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class MentoringServiceTest {

    @Autowired
    private MentoringService mentoringService;

    @Test
    public void addTest() {
        MentoringDTO mentoringDTO = MentoringDTO.builder()
                .id("test")
                .maxNumPeople(5)
                .menteeNum(4)
                .region("대구 광역시 반월당 호호하하 2번지")
                .lngName("JAVA")
                .meeting(true)
                .on_off(true)
                .roomNo(4)
                .payment(true)
                .build();
        mentoringService.add(mentoringDTO);
    }

    @Test
    public void getAllTest() {
        List<MentoringDTO> mentoringDTOList = mentoringService.getAll();
        mentoringDTOList.forEach(mentoringDTO -> log.info(mentoringDTO));
    }
}