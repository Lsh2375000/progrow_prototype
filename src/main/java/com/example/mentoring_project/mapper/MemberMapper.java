package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void insert(MemberVO memberVO);
}
