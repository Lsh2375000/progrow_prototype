package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.ReplyVO;
import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.ReplyDTO;
import com.example.mentoring_project.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class ReplyServiceImpl implements ReplyService{
    private final ModelMapper modelMapper;
    private final ReplyMapper replyMapper;



    @Override
    public Long insertReply(ReplyDTO replyDTO) {
        ReplyVO replyVO = modelMapper.map(replyDTO, ReplyVO.class);

        replyMapper.insertReply(replyVO);
        return null;
    }

    @Override
    public PageResponseDTO<ReplyDTO> getListOfBoard(Long boardNo, PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(pageRequestDTO.getPage() <= 0 ? 0 : pageRequestDTO.getPage() -1,
                pageRequestDTO.getSize(), Sort.by("rno").ascending());
        Page<ReplyVO> result = replyMapper.listOfBoard(boardNo, pageable);
        List<ReplyDTO> dtoList = result.getContent().stream().map(replyVO ->
                modelMapper.map(replyVO, ReplyDTO.class)).collect(Collectors.toList());
        return PageResponseDTO.<ReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();
    }

    @Override
    public ReplyDTO read(Long rno) {
        Optional<ReplyVO> replyVOOptional = replyMapper.findById(rno);
        ReplyVO replyVO = replyVOOptional.orElseThrow();
        return modelMapper.map(replyVO, ReplyDTO.class);
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Optional<ReplyVO> replyVOOptional = replyMapper.findById(replyDTO.getRno());
        ReplyVO replyVO = replyVOOptional.orElseThrow();
        replyVO.changeText(replyDTO.getReplyText());
       replyMapper.save(replyVO);
    }

    @Override
    public void remove(Long rno) {
        replyMapper.delete(rno);

    }


}
