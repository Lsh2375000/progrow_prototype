package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.BoardListAllDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface BoardSearch {
    Page<BoardListAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable);
}
