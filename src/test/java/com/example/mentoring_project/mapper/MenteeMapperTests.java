package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MenteeVO;
import com.example.mentoring_project.domain.MentoringVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class MenteeMapperTests {

    @Autowired
    private MenteeMapper menteeMapper;

    @Test
    public void insertTest() {
        for (int i = 0; i < 20; i++) {
            MenteeVO menteeVO = MenteeVO.builder()
                    .mentee_id("멘티 아이디 테스트" + i)
                    .passwd("멘티 비밀번호 테스트" + i)
                    .name("nameTest" + i)
                    .region("멘티 지역 테스트" + i)
                    .age(20 + i)
                    .nickname("멘티 닉네임 테스트" + i)
                    .build();
            menteeMapper.insert(menteeVO);
        }

    }

    @Test
    public void selectAllTest() {
        List<MenteeVO> menteeVOList = menteeMapper.selectAll();
        menteeVOList.forEach(menteeVO -> log.info(menteeVO));
    }

    @Test
    public void selectOne() {
        Long menteeNo = 5L;
        MenteeVO menteeVO = menteeMapper.selectOne(menteeNo);
        log.info(menteeVO);
    }


    @Test
    public void updateTest() {
        log.info(menteeMapper.selectOne(5L));
        MenteeVO menteeVO = MenteeVO.builder()
                .menteeNo(5L)
                .passwd("1234")
                .name("이름 수정테스트")
                .region("지역수정 테스트")
                .nickname("수정 테스트")
                .lngName("Python")
                .build();
        menteeMapper.update(menteeVO);
        log.info(menteeMapper.selectOne(5L));
    }

    @Test
    public void deleteTest() {
        menteeMapper.delete(5L);
    }
}
