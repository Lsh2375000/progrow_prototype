package com.example.mentoring_project.repository.search;

import com.example.mentoring_project.domain.BoardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<BoardVO> search1(Pageable pageable);
}
