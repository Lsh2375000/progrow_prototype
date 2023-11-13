package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MenteeDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@Log4j2
public class MenteeServiceTest {
    @Autowired
    private MenteeService menteeService;

    @Test
    public void addTest() {
        for (int i = 0; i < 30; i++) {
            MenteeDTO menteeDTO = MenteeDTO.builder()
                    .mentee_id("test" + i)
                    .passwd("12345" + i)
                    .name("서비스 addTest" + i)
                    .region("멘티 서비스 add 지역")
                    .age(25 + i)
                    .nickname("서비스 test" + i)
                    .build();
            menteeService.add(menteeDTO);
        }
    }

    @Test
    public void getAllTest() {
        List<MenteeDTO> menteeDTOList = menteeService.getAll();
        menteeDTOList.forEach(menteeDTO -> log.info(menteeDTO));
    }

    @Test
    public void getOne() {
        Long menteeNo = 6L;
        MenteeDTO menteeDTO = menteeService.getOne(menteeNo);
        log.info(menteeDTO);
    }

    @Test
    public void modify() {
        Long menteeNo = 6L;
        log.info(menteeService.getOne(menteeNo));
        MenteeDTO menteeDTO = MenteeDTO.builder()
                .menteeNo(menteeNo)
                .passwd("서비스수정1")
                .name("서비스수정1")
                .region("서비스수정1")
                .nickname("서비스수정1")
                .lngName("C#")
                .build();
        menteeService.modify(menteeDTO);
        log.info(menteeService.getOne(menteeNo));
    }


    @Test
    public void remove() {
        Long menteeNo = 6L;
        menteeService.remove(menteeNo);
    }
}