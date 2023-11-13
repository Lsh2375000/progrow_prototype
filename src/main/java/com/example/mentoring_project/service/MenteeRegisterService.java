package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MenteeRegisterDTO;

import java.util.List;

public interface MenteeRegisterService {

    void add(MenteeRegisterDTO menteeRegisterDTO);
    List<MenteeRegisterDTO> getAll();
    MenteeRegisterDTO getOne(Long menteeNo, String mode);
    void modifyOne(MenteeRegisterDTO menteeRegisterDTO);
    void removeOne(Long menteeNo);
}
