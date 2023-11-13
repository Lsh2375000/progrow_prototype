//package com.example.mentoring_project.mapper;
//
//import com.example.mentoring_project.domain.MentorRegisterVO;
//import lombok.extern.log4j.Log4j2;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//
//@SpringBootTest
//@Log4j2
//class MentorRegisterMapperTests {
//    @Autowired
//    private MentorRegisterMapper mentorRegisterMapper;
//
//    @Test
//    public void insertTest() {
//        for (int i = 1; i < 11; i++) {
//            MentorRegisterVO mentorRegisterVO = MentorRegisterVO.builder()
//                    .mentor_id("멘토Test" + i)
//                    .passwd("1234" + i)
//                    .name("멘토Name" + i)
//                    .region("대구시 수성구 황금동" + i)
//                    .age(10 + i)
//                    .nickname("멘토Nick" + i)
//                    .lngName("Java" + i)
//                    .portfolio("portFolioTest" + i)
//                    .intro("let me introduce")
//                    .type("tor")
//                    .build();
//            mentorRegisterMapper.insert(mentorRegisterVO);
//        }
//    }
//
//    @Test
//    public void selectAllTest() {
//        List<MentorRegisterVO> voList = mentorRegisterMapper.selectAll();
//        voList.forEach(log::info);
//    }
//
//    @Test
//    public void selectOneTest() {
//        log.info(mentorRegisterMapper.selectOne(2L));
//    }
//
//    @Test
//    public void updateTest() {
//        MentorRegisterVO mentorRegisterVO = MentorRegisterVO.builder()
//                .mentorNo(10L)
//                .mentor_id("멘토TestUp")
//                .passwd("1111")
//                .name("멘토NameUp")
//                .region("대구시 북구 매천동")
//                .age(10)
//                .nickname("멘토NickUp")
//                .lngName("C++")
//                .portfolio("멘토TestUp")
//                .intro("let me introduce myself")
//                .type("tor")
//                .build();
//        mentorRegisterMapper.update(mentorRegisterVO);
//    }
//
//    @Test
//    public void deleteTest() {
//        mentorRegisterMapper.delete(10L);
//    }
//
//}