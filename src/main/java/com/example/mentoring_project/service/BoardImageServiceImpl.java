package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.BoardImageVO;
import com.example.mentoring_project.dto.BoardImageDTO;
import com.example.mentoring_project.mapper.BoardImageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class BoardImageServiceImpl implements BoardImageService{
    private final BoardImageMapper boardImageMapper;
    private final ModelMapper modelMapper;

    @Override
    public String register(BoardImageDTO boardImageDTO) {
        BoardImageVO boardImageVO = modelMapper.map(boardImageDTO, BoardImageVO.class);
        boardImageMapper.register(boardImageVO);

        return null;
    }
}
