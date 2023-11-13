package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MentoringVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MentoringMapper {

    void insert(MentoringVO mentoringVO);


    List<MentoringVO> selectAll();
}
