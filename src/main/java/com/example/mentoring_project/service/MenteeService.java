package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.MenteeDTO;

import java.util.List;

public interface MenteeService {

    void add(MenteeDTO menteeDTO);

    List<MenteeDTO> getAll();

    MenteeDTO getOne(Long menteeNo);

    void modify(MenteeDTO menteeDTO);

    void remove(Long menteeNo);


}
