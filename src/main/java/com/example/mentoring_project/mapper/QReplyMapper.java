package com.example.mentoring_project.mapper;


import com.example.mentoring_project.domain.QReplyVO;
import com.example.mentoring_project.domain.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface QReplyMapper {

    void insert(QReplyVO qReplyVO);
    QReplyVO selectOne(Long qRno);
    static void update(QReplyVO qReplyVO)
    {};
    static void delete(Long qRno)
    {};
    List<ReplyVO> selectListOfBoard(@Param("qBoardNo") Long qBoardNo, @Param("skip") int skip, @Param("size") int size);
    int getCount(Long qBoardNo);


}
