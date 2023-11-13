package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MentorDTO;

import java.util.List;

public interface MentorService {

    void add(MentorDTO mentorDTO);

    List<MentorDTO> getAll();

    MentorDTO getOne(Long mentorNo);

    void modify(MentorDTO mentorDTO);

    void remove(Long mentorNo);
}
