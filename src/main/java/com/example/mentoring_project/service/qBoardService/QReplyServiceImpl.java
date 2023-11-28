package com.example.mentoring_project.service.qBoardService;

import com.example.mentoring_project.domain.qBoardVO.QReplyVO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.dto.qBoardDTO.QReplyDTO;
import com.example.mentoring_project.mapper.qBoardMapper.QReplyMapper;
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
    public Long addReplyQ(QReplyDTO qReplyDTO) {
        QReplyVO qReplyVO = modelMapper.map(qReplyDTO, QReplyVO.class);
        qReplyMapper.insertQR(qReplyVO);
        return qReplyVO.getQnaRno();
    }

//    @Override
//    public Long registerReQ(QReplyDTO qReplyDTO) {
//        QReplyVO qReplyVO = modelMapper.map(qReplyDTO, QReplyVO.class);
//        qReplyMapper.insert(qReplyVO);
//        return qReplyVO.getQRno();
//    }
    @Override
    public QReplyDTO read(Long qRno) {
        QReplyVO qReplyVO = qReplyMapper.selectOneQR(qRno);
        return modelMapper.map(qReplyVO, QReplyDTO.class);
    }

    @Override
    public void modifyOne(QReplyDTO qReplyDTO) {
        QReplyVO qReplyVO = qReplyMapper.selectOneQR(qReplyDTO.getQnaRno());
        qReplyVO.changeQnaText(qReplyVO.getContent());
        qReplyMapper.updateOneQR(qReplyVO);
    }

    @Override
    public void removeOne(Long qRno) {
        qReplyMapper.deleteOneQR(qRno);
    }

    @Override
    public PageResponseDTO<QReplyDTO> getListOfBoardQR(long qnaBoardNo, PageRequestDTO pageRequestDTO) {
        List<QReplyVO> voList = qReplyMapper.selectListOfBoardQR(qnaBoardNo, pageRequestDTO.getSkip(), pageRequestDTO.getSize());
        List<QReplyDTO> dtoList = new ArrayList<>();

        voList.forEach(qReplyVO -> dtoList.add(modelMapper.map(qReplyVO, QReplyDTO.class)));

        return PageResponseDTO.<QReplyDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(qReplyMapper.getCountQR(qnaBoardNo))
                .build();

    }

}
