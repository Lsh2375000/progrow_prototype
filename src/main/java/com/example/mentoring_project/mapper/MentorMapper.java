package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MenteeVO;
import com.example.mentoring_project.domain.MentorVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MentorMapper {

    void insert(MentorVO mentorVO); // 멘토 회원등록

    List<MentorVO> selectAll(); // 전체 멘토 회원조회

    MentorVO selectOne(String mentor_id); // 특정 멘토 회원 정보 가져오기

    void update(MentorVO mentorVO); // 멘토 회원 수정


    void delete(String mentor_id); // 멘토 회원 삭제

    void updatePw(String passwd ,String mentor_id); // 비밀번호 수정
}
