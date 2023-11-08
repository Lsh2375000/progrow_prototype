package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MenteeRegisterVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenteeRegisterMapper {
    void insert(MenteeRegisterVO menteeRegisterVO); // 멘티 가입
    MenteeRegisterVO selectOne(Long menteeNo); // 멘티 조회
    void update(MenteeRegisterVO menteeRegisterVO); // 멘티 수정
    void delete(Long menteeNo); // 멘티 삭제
}
