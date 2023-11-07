package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MentoringVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MentoringMapper {

    void insert(MentoringVO mentoringVO);



}
