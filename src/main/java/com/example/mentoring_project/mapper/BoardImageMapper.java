package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.BoardImageVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardImageMapper {

    void register(BoardImageVO boardImageVO); //이미지 생성

}
