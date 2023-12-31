package com.example.mentoring_project.service.qBoardService;

import com.example.mentoring_project.domain.qBoardVO.QBoardListAllVO;
import com.example.mentoring_project.domain.qBoardVO.QBoardVO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.dto.qBoardDTO.QBoardDTO;
import com.example.mentoring_project.dto.qBoardDTO.QBoardListAllDTO;
import com.example.mentoring_project.mapper.qBoardMapper.QBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class QBoardServiceImpl implements QBoardService {
    private final ModelMapper modelMapper; // 모델 mapper 의존성 주입
    private final QBoardMapper qBoardMapper; // 모델 qBoardMapper 의존성 주입

    @Override
    public QBoardDTO getOne(Long qnaBoardNo, String read) { // 특정 게시글 데이터 조회하기
        if (read.equals("read")) {
            qBoardMapper.updateHit(qnaBoardNo);
        }

        QBoardDTO qBoardDTO = modelMapper.map(qBoardMapper.selectOne(qnaBoardNo), QBoardDTO.class);

        return qBoardDTO;
    }

    @Override
    public void getAll(QBoardDTO qBoardDTO) { // 게시글 전체 데이터 조회하기
        QBoardDTO qBoardDTO1 = modelMapper.map(qBoardDTO, QBoardDTO.class);
    }

    @Override
    public void add(QBoardDTO qBoardDTO) { // 특정 게시글 등록
        QBoardVO qBoardVO = modelMapper.map(qBoardDTO, QBoardVO.class);
        qBoardMapper.insert(qBoardVO);
    }

    @Override
    public void deleteOne(Long qnaBoardNo) { // 특정 게시물 1개 삭제
        qBoardMapper.deleteOne(qnaBoardNo);
    }


    @Override
    public QBoardDTO selectOne(Long qnaBoardNo) { // 특정 게시글 1개 조회
        QBoardVO qBoardVO = qBoardMapper.selectOne(qnaBoardNo);
        QBoardDTO qBoardDTO = modelMapper.map(qBoardVO, QBoardDTO.class);
        return qBoardDTO;
    }

    @Override
    public void modifyOne(QBoardDTO qBoardDTO){ // 특정 게시글 1개 수정
        QBoardVO qBoardVO = modelMapper.map(qBoardDTO, QBoardVO.class);
        qBoardMapper.update(qBoardVO);
    }

    // 게시물 전체 리스트 조회
    @Override
    public PageResponseDTO<QBoardListAllDTO> getList(PageRequestDTO pageRequestDTO) {
        List<QBoardListAllVO> voList = qBoardMapper.selectList(pageRequestDTO);
        log.info(voList);
        List<QBoardListAllDTO> dtoList = new ArrayList<>();
        voList.forEach(vo -> dtoList.add(modelMapper.map(vo, QBoardListAllDTO.class)));

        int total = qBoardMapper.getCount(pageRequestDTO);

        PageResponseDTO<QBoardListAllDTO> pageResponseDTO = PageResponseDTO.<QBoardListAllDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }


}
