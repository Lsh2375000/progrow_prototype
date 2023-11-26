package com.example.mentoring_project.service;

import com.example.mentoring_project.dto.BoardAllDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface BoardSearch {
    Page<BoardAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable);
}
