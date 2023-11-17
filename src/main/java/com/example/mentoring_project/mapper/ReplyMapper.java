package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Mapper
public interface ReplyMapper {

   void insertReply(ReplyVO replyVO); //댓글 작성

   Page<ReplyVO> listOfBoard(Long boardNo, Pageable pageable);

   Optional<ReplyVO> findById(Long rno);

   void save(ReplyVO replyVO);

   void delete(Long rno);
}
