package com.example.mentoring_project.service.mentoringService;

import com.example.mentoring_project.dto.mentoringDTO.MentoringDTO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;

import java.util.List;

public interface MentoringService {
    void add(MentoringDTO mentoringDTO); // 멘토링 방 생성

    List<MentoringDTO> getAll(); // 멘토링 방 전체 목록

    PageResponseDTO<MentoringDTO> getList(PageRequestDTO pageRequestDTO);

    MentoringDTO getOne(Long mNo);

    void modifyOne(MentoringDTO mentoringDTO);

    void removeOne(Long mNo);
}
