package com.example.mentoring_project.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "boardVO")
public class BoardImageVO implements Comparable<BoardImageVO>{
    @Id
    private String uuid; //첨부파일 고유값

    private String fileName;

    private int ord; //순번

    @ManyToOne
    private BoardVO boardVO;

    @Override
    public int compareTo(BoardImageVO boardImageVO){
        return this.ord - boardImageVO.ord;
    }

    public void changeBoard(BoardVO boardVO){
        this.boardVO = boardVO;
    }
}
