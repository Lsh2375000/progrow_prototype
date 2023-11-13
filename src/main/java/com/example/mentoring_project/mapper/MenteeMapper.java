package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MenteeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenteeMapper {

    void insert(MenteeVO memberVO); // 멘티 회원등록

    List<MenteeVO> selectAll(); // 전체 멘티 회원조회

    MenteeVO selectOne(Long memberNo); // 특정 멘티 회원 가져오기

    void update(MenteeVO memberVO); // 멘티 회원 수정


    void delete(Long memberNo); // 멘티 회원 삭제

}
