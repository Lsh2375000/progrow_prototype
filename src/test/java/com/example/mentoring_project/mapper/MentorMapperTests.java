//package com.example.mentoring_project.mapper;
//
//import com.example.mentoring_project.domain.MenteeVO;
//import com.example.mentoring_project.domain.MentorVO;
//import lombok.extern.log4j.Log4j2;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//@Log4j2
//public class MentorMapperTests {
//
//    @Autowired
//    private MentorMapper mentorMapper;
//
//    @Test
//    public void insertTest() {
//        for (int i = 0; i < 20; i++) {
//            MentorVO mentorVO = MentorVO.builder()
//                    .mentor_id("멘토 아이디 테스트" + i)
//                    .passwd("비밀번호 테스트" + i)
//                    .name("nameTest" + i)
//                    .region("지역 테스트" + i)
//                    .age(20 + i)
//                    .nickname("닉네임 테스트" + i)
//                    .lngName("JAVA")
//                    .portfolio("포폴테스트")
//                    .intro("나는 누구고 뭐하고 어쩌구 저쩌구")
//                    .build();
//            mentorMapper.insert(mentorVO);
//        }
//
//    }
//
//    @Test
//    public void selectAllTest() {
//        List<MentorVO> mentorVOList = mentorMapper.selectAll();
//        mentorVOList.forEach(mentorVO -> log.info(mentorVO));
//    }
//
//    @Test
//    public void selectOne() {
//        Long mentorNo = 5L;
//        MentorVO mentorVO = mentorMapper.selectOne(mentorNo);
//        log.info(mentorVO);
//    }
//
//
//    @Test
//    public void updateTest() {
//        log.info(mentorMapper.selectOne(5L));
//        MentorVO mentorVO = MentorVO.builder()
//                .mentorNo(5L)
//                .passwd("1234")
//                .name("이름 수정테스트")
//                .region("지역수정 테스트")
//                .nickname("수정 테스트")
//                .lngName("Python")
//                .portfolio("")
//                .build();
//        mentorMapper.update(mentorVO);
//        log.info(mentorMapper.selectOne(5L));
//    }
//
//    @Test
//    public void deleteTest() {
//        mentorMapper.delete(5L);
//    }
//}
