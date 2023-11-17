package com.example.mentoring_project.repository.search;

import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class BoardSearchImpl implements BoardSearch {
    private final ModelMapper modelMapper;
    private final BoardMapper boardMapper;

    @Override
    public Page<BoardVO> search1(Pageable pageable) {
        return null;
    }

}
