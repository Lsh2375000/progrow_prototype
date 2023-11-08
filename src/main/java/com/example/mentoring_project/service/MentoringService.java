package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MentoringDTO;

import java.util.List;

public interface MentoringService {

    void add(MentoringDTO mentoringDTO); // 멘토링 방 생성

    List<MentoringDTO> getAll(); // 멘토링 방 전체 목록



}
