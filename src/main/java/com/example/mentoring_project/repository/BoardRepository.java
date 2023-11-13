package com.example.mentoring_project.repository;


import com.example.mentoring_project.domain.BoardVO;

import java.util.Optional;

public interface BoardRepository{
    Optional<BoardVO> findById(Long boardNo);
}
