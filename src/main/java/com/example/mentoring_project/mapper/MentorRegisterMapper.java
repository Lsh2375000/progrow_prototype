package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MentorRegisterVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MentorRegisterMapper {
    void insert(MentorRegisterVO mentorRegisterVO); // 멘토 가입
    MentorRegisterVO selectOne(Long mentorNo); // 확인차 조회
    void update(MentorRegisterVO mentorRegisterVO); // 멘토 수정
    void delete(Long mentorNo); // 멘토 회원 삭제
}
