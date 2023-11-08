package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MentorRegisterDTO;

public interface MentorRegisterService {

    void add(MentorRegisterDTO mentorRegisterDTO);

    MentorRegisterDTO getOne(Long mentorNo, String mode);

    void modifyOne(MentorRegisterDTO menteeRegisterDTO);

    void removeOne(Long memtorNo);
}
