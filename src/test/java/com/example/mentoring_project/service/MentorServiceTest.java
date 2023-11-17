package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MemberJoinDTO;
import com.example.mentoring_project.dto.MentorDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Log4j2
public class MentorServiceTest {

    @Autowired
    private MentorService mentorService;


    @Test
    public void add() {
        MentorDTO mentorDTO = MentorDTO.builder()
                .mentor_id("All test")
                .passwd("1111")
                .name("All test")
                .region("All test")
                .nickname("All test")
                .lngName("All test")
                .portfolio("All test")
                .intro("All test")
                .build();
        mentorService.add(mentorDTO);
    }

    @Test
    public void getAll() {
        List<MentorDTO> mentorDTOList = mentorService.getAll();
        mentorDTOList.forEach(mentorDTO -> log.info(mentorDTO));
    }

    @Test
    public void getOne() {
        log.info(mentorService.getOne(56L));
    }

}