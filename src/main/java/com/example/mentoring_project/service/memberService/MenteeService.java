package com.example.mentoring_project.service.memberService;

import com.example.mentoring_project.dto.memberDTO.MenteeDTO;

import java.util.List;

public interface MenteeService {

    void add(MenteeDTO menteeDTO); // 멘티 회원가입

    List<MenteeDTO> getAll(); // 멘티 목록

    MenteeDTO getOne(String mentee_id); // 해당 멘티 회원

    void modify(MenteeDTO menteeDTO); // 멘티 정보 수정

    void remove(String mentee_id); // 멘티 회원탈퇴

    void modifyPw(String passwd, String mentee_id);

}
