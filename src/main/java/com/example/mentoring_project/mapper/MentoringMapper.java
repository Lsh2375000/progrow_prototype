package com.example.mentoring_project.mapper;

import com.example.mentoring_project.domain.MentoringVO;
import com.example.mentoring_project.dto.PageRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MentoringMapper {
    // 이 부분(매퍼) 작성 후 MentoringMapper.xml 에 쿼리 작성(마이바티스)
    String getTime();
    void insert(MentoringVO mentoringVO);

    List<MentoringVO> selectAll();

    // 상세보기 기능(조회) "/mentoring/read?mno=xx" 와 같이 MentoringController를 호출 하도록 개발
    MentoringVO selectOne(Long mNo);
    void update(MentoringVO mentoringVO); // 수정
    void delete(Long mNo); // 삭제

    List<MentoringVO> selectList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
}
