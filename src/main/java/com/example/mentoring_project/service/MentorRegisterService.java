package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MentorRegisterDTO;

import java.util.List;

public interface MentorRegisterService {

    void add(MentorRegisterDTO mentorRegisterDTO);

    List<MentorRegisterDTO> getAll();

    MentorRegisterDTO getOne(Long mentorNo, String mode);

    void modifyOne(MentorRegisterDTO menteeRegisterDTO);

    void removeOne(Long memtorNo);
}
