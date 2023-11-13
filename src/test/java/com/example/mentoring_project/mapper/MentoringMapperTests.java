package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MentoringVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Log4j2
public class MentoringMapperTests {

    @Autowired
    private MentoringMapper mentoringMapper;

    @Test
    public void insertTest() {
        for (int i = 0; i < 50; i++) {
            MentoringVO mentoringVO = MentoringVO.builder()
                    .id("test" + i)
                    .maxNumPeople(3)
                    .menteeNum(2)
                    .region("대구" + i)
                    .lngName("JAVA" + i)
                    .meeting(true)
                    .on_off(true)
                    .build();
            mentoringMapper.insert(mentoringVO);
        }
    }

    @Test
    public void selectAllTest() {
        List<MentoringVO> mentoringVOList = mentoringMapper.selectAll();
        mentoringVOList.forEach(mentoringVO -> log.info(mentoringVO));
    }

    @Test
    public void selectOneTest() {
        Long mNo = 1L;
        MentoringVO mentoringVO = mentoringMapper.selectOne(mNo);
        log.info(mentoringVO);
    }

    @Test
    public void updateTest() {
        MentoringVO mentoringVO = MentoringVO.builder()
                .mNo(1L)
                .region("서울")
                .lngName("Python")
                .on_off(false)
                .build();
        mentoringMapper.update(mentoringVO);
        log.info(mentoringMapper.selectOne(1L));
    }

    @Test
    public void deleteTest() {
        mentoringMapper.delete(1L);
    }
}
