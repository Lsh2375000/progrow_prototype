package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.SMemberVO;
import com.example.mentoring_project.dto.MemberSecurityDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SMemberMapper {

    void addMember(SMemberVO memberVO); // 회원 추가
    void addMemberRole(String member_mid, Integer role_set); // 회원 롤 입력

    SMemberVO getMemberId(String mid);  // 회원 아이디 정보 가져오기

    SMemberVO getMemberNickname(String nickname); // 닉네임 중복 확인

    void updateMember(String mpw, String nickname, String mid); // 해당 아이디의 비밀번호 닉네임 변경

    List<SMemberVO> getMemberList(); // 전체 회원 리스트

    void updatePassword(String mpw, String mid); // 비밀번호 재설정

    void deleteMember(String mid);
}
