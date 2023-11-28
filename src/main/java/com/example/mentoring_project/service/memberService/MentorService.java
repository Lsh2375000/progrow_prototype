package com.example.mentoring_project.service.memberService;

import com.example.mentoring_project.dto.memberDTO.MentorDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MentorService {

    void add(MentorDTO mentorDTO, List<MultipartFile> files); // 멘토 회원가입

    List<MentorDTO> getAll(); // 멘토 목록

    MentorDTO getOne(String mentor_id); // 해당 멘토 정보

    void modify(MentorDTO mentorDTO, List<MultipartFile> files); // 멘토 정보 수정

    void remove(String mentor_id); // 멘토 회원 탈퇴

    void modifyPw(String passwd, String mentor_id);
}
