package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.BoardListAllDTO;
import com.example.mentoring_project.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class BoardSearchImpl implements BoardSearch{
    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;

    @Override
    public Page<BoardListAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable) {

        return null;
    }



}
