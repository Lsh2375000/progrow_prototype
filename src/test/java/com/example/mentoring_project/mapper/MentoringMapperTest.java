package com.example.mentoring_project.mapper;


import com.example.mentoring_project.domain.mentoringVO.MentoringVO;
import com.example.mentoring_project.mapper.mentoringMapper.MentoringMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class MentoringMapperTest {
    @Autowired(required = false)
    private MentoringMapper mentoringMapper;


//    UPDATE mentoring SET mentee_id =
//        if(mentee_id=NULL,#{mentee_id},CONCAT_WS(', ', mentee_id, #{mentee_id}))
//    WHERE mNo=#{mNo};
    @Test
    void recruitInsertTest() {
        Long mNo = 59L;
        MentoringVO mentoringVO = MentoringVO.builder()
                .mentee_id("test_59")
                .mNo(mNo)
                .build();

        mentoringMapper.recruitInsert(mentoringVO);
    }


    @Test
    void insertTest() {
        for (Long i = 1L; i < 30L; i++) {
            MentoringVO mentoringVO = MentoringVO.builder()
                    .mentor_id("mento@" + i + "naver.com")
                    .region("서울 " + i)
                    .lngName("JAVA" + i)
                    .meeting(true)
                    .on_off(true)
                    .build();

            mentoringMapper.insert(mentoringVO);
        }
    }

//    @Test
//    void menteeRecruit() {
//        String mentee_id = "inhabeak@gmail.com";
//        MenteeVO menteeVO = MenteeVO.builder()
//                .mentee_id(mentee_id)
//                .build();
//        mentoringMapper.menteeRecruit(menteeVO);
//
//    }
//
//    @Test
//    void getMenteeIsMentoring() {
//        log.info("아아아..."+mentoringMapper.getMenteeIsMentoring("inhabeak@gmail.com"));
//    }


}