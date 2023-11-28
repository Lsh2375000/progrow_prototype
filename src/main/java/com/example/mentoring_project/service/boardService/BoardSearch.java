package com.example.mentoring_project.service.boardService;

import com.example.mentoring_project.dto.boardDTO.BoardAllDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface BoardSearch {
    Page<BoardAllDTO> searchWithAll(String[] types, String keyword, Pageable pageable);
}
