package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.SMemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SMemberMapper {

    void addMember(SMemberVO memberVO); // 회원 추가
    void addMemberRole(String member_mid, Integer role_set); // 회원 롤 입력

    SMemberVO getMemberId(String mid);  // 회원 아이디 정보 가져오기

    List<SMemberVO> getMemberList(); // 나중에 추가

//    SMemberVO findByEmail(String email); // 회원 이메일 찾기

    void updatePassword(String mpw, String mid); // 회원 소셜로그인 비밀번호 변경

    SMemberVO findMemberPassword(String mid);
}
