package com.example.mentoring_project.repository;


import com.example.mentoring_project.domain.BoardVO;
import com.example.mentoring_project.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardVO, Long>, BoardSearch {
    @Query(value = "select now()", nativeQuery = true)
    String getTime();

    Optional<BoardVO> findById(Long boardNo);

}
