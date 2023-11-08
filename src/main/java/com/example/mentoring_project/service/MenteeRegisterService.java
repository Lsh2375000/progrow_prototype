package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MenteeRegisterDTO;

public interface MenteeRegisterService {

    void add(MenteeRegisterDTO menteeRegisterDTO);
    MenteeRegisterDTO getOne(Long menteeNo, String mode);
    void modifyOne(MenteeRegisterDTO menteeRegisterDTO);
    void removeOne(Long memteeNo);
}
