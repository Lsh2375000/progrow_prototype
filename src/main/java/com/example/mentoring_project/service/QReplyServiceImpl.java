package com.example.mentoring_project.service;

import com.example.mentoring_project.domain.QReplyVO;
import com.example.mentoring_project.domain.ReplyVO;
import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.QReplyDTO;
import com.example.mentoring_project.mapper.QReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class QReplyServiceImpl implements QReplyService {
    private final ModelMapper modelMapper;
    private final QReplyMapper qReplyMapper;

    @Override
    public Long register(QReplyDTO qReplyDTO) {
        QReplyVO qReplyVO = modelMapper.map(qReplyDTO, QReplyVO.class);
        qReplyMapper.insert(qReplyVO);
        return qReplyVO.getQRno();
    }

//    @Override
//    public Long registerReQ(QReplyDTO qReplyDTO) {
//        QReplyVO qReplyVO = modelMapper.map(qReplyDTO, QReplyVO.class);
//        qReplyMapper.insert(qReplyVO);
//        return qReplyVO.getQRno();
//    }
    @Override
    public QReplyDTO read(Long qRno) {
        QReplyVO qReplyVO = qReplyMapper.selectOne(qRno);

        return modelMapper.map(qReplyVO, QReplyDTO.class);
    }

    @Override
    public void modify(QReplyDTO qReplyDTO) {
        QReplyVO qReplyVO = qReplyMapper.selectOne(qReplyDTO.getQRno());
        qReplyVO.changeQnaText(qReplyVO.getContent());
        QReplyMapper.update(qReplyVO);
    }

    @Override
    public void remove(Long qRno) {
        QReplyMapper.delete(qRno);
    }

    @Override
    public PageResponseDTO<QReplyDTO> getListOfBoard(Long qBoardNo, PageRequestDTO pageRequestDTO) {
        List<ReplyVO> voList = qReplyMapper.selectListOfBoard(qBoardNo, pageRequestDTO.getSkip(), pageRequestDTO.getSize());
        List<QReplyDTO> dtoList = new ArrayList<>();

        voList.forEach(qReplyVO -> dtoList.add(modelMapper.map(qReplyVO, QReplyDTO.class)));

        return PageResponseDTO.<QReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(qReplyMapper.getCount(qBoardNo))
                .build();
    }
}
