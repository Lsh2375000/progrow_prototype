package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MentorRegisterVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Log4j2
class MentorRegisterMapperTests {
    @Autowired
    private MentorRegisterMapper mentorRegisterMapper;

    private Long mentorNo; // 멘토 넘버
    private String mentee_id; // 멘토 ID
    private String passwd; // 멘토 PW
    private String name; // 멘토 이름
    private String region; // 멘토 지역
    private int age; // 멘토 나이
    private String nickname; // 멘토 닉네임
    private String lngName; // 멘토 프로그래밍 언어
    private String portfolio; // 멘토 포트폴리오
    private String intro; // 멘토 소개
    private int mNo; // 멘토링 세션방 고유번호
    private int gradeByMNum; // 멘토링 횟수(횟수에 따라 멘토링 등급 반여)
    private String type; // 멘토, 멘티 타입

    @Test
    public void insertTest() {
        for (int i = 1; i < 11; i++) {
            MentorRegisterVO mentorRegisterVO = MentorRegisterVO.builder()
                    .mentor_id("mentorTest" + i)
                    .passwd("1234" + i)
                    .name("mentorName" + i)
                    .region("대구시 수성구 황금동" + i)
                    .age(10 + i)
                    .nickname("mentorNick" + i)
                    .lngName("Java" + i)
                    .portfolio("portFolioTest" + i)
                    .intro("let me introduce")
                    .type("tor")
                    .build();
            mentorRegisterMapper.insert(mentorRegisterVO);
        }
    }

    @Test
    public void selectOneTest() {
        log.info(mentorRegisterMapper.selectOne(2L));
    }

    @Test
    public void updateTest() {
        MentorRegisterVO mentorRegisterVO = MentorRegisterVO.builder()
                .mentor_id("mentorTestUp")
                .passwd("1111")
                .name("mentorNameUp")
                .region("대구시 북구 매천동")
                .age(10)
                .nickname("mentorNickUp")
                .lngName("C++")
                .portfolio("portFolioTestUp")
                .intro("let me introduce myself")
                .type("tor")
                .build();
        mentorRegisterMapper.update(mentorRegisterVO);
    }

    @Test
    public void deleteTest() {
        mentorRegisterMapper.delete(10L);
    }

}