package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.memberDTO.MenteeDTO;
import com.example.mentoring_project.service.memberService.MenteeService;
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
    public void add() {
        MenteeDTO menteeDTO = MenteeDTO.builder()
                .mentee_id("All test")
                .passwd("1111")
                .name("All test")
                .region("All test")
                .nickname("All test")
                .lngName("All test")
                .build();
        menteeService.add(menteeDTO);
    }

    @Test
    public void getAll() {
        List<MenteeDTO> menteeDTOList = menteeService.getAll();
        menteeDTOList.forEach(menteeDTO -> log.info(menteeDTO));
    }

    @Test
    public void getOne() {
        log.info(menteeService.getOne("60L"));
    }

}