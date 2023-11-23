package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MentorDTO;

import java.util.List;

public interface MentorService {

    void add(MentorDTO mentorDTO); // 멘토 회원가입

    List<MentorDTO> getAll(); // 멘토 목록

    MentorDTO getOne(String mentor_id); // 해당 멘토 정보

    void modify(MentorDTO mentorDTO); // 멘토 정보 수정

    void remove(String mentor_id); // 멘토 회원 탈퇴

    void modifyPw(String passwd, String mentor_id);
}
