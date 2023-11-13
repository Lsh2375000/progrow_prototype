package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MenteeDTO;
import com.example.mentoring_project.dto.MentorDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class MentorServiceTests {

    @Autowired
    private MentorService mentorService;

    @Test
    public void addTest() {
        for (int i = 0; i < 30; i++) {
            MentorDTO mentorDTO = MentorDTO.builder()
                    .mentor_id("test" + i)
                    .passwd("12345" + i)
                    .name("서비스 addTest" + i)
                    .region("멘토 서비스 add 지역")
                    .age(25 + i)
                    .nickname("서비스 test" + i)
                    .lngName("JAVA")
                    .portfolio("test포폴" + i)
                    .intro("테스트 자기소개")
                    .build();
            mentorService.add(mentorDTO);
        }
    }

    @Test
    public void getAllTest() {
        List<MentorDTO> mentorDTOList = mentorService.getAll();
        mentorDTOList.forEach(mentorDTO -> log.info(mentorDTO));
    }

    @Test
    public void getOne() {
        Long mentorNo = 6L;
        MentorDTO mentorDTO = mentorService.getOne(mentorNo);
        log.info(mentorDTO);
    }

    @Test
    public void modify() {
        Long mentorNo = 6L;
        log.info(mentorService.getOne(mentorNo));
        MentorDTO mentorDTO = MentorDTO.builder()
                .mentorNo(mentorNo)
                .passwd("서비스수정1")
                .name("서비스수정1")
                .region("서비스수정1")
                .nickname("서비스수정1")
                .lngName("C#")
                .portfolio("포폴수정")
                .build();
        mentorService.modify(mentorDTO);
        log.info(mentorService.getOne(mentorNo));
    }


    @Test
    public void remove() {
        Long mentorNo = 6L;
        mentorService.remove(mentorNo);
    }
}
