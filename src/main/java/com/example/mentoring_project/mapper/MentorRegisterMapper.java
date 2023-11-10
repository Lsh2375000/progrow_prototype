package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MentorRegisterVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MentorRegisterMapper {
    void insert(MentorRegisterVO mentorRegisterVO); // 멘토 가입
    List<MentorRegisterVO> selectAll(); // 멘토 전체 유저 조회
    MentorRegisterVO selectOne(Long mentorNo); // 멘토 특정 유저 조회
    void update(MentorRegisterVO mentorRegisterVO); // 멘토 수정
    void delete(Long mentorNo); // 멘토 회원 삭제

    
}
