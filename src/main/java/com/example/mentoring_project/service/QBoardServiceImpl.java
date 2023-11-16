package com.example.mentoring_project.service;


import com.example.mentoring_project.domain.QBoardVO;
import com.example.mentoring_project.dto.*;
import com.example.mentoring_project.mapper.QBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class QBoardServiceImpl implements QBoardService{
    private final ModelMapper modelMapper;
    private final QBoardMapper qBoardMapper;

    @Override
    public QBoardDTO getOne(Long qBoardNo, String view) {
        if (view.equals("view")) {
            qBoardMapper.updateHit(qBoardNo);
        }

        QBoardDTO qBoardDTO = modelMapper.map(qBoardMapper.selectOne(qBoardNo), QBoardDTO.class);

        return qBoardDTO;
    }

    @Override
    public void getAll(QBoardDTO qBoardDTO) {
        QBoardDTO qBoardDTO1 = modelMapper.map(qBoardDTO, QBoardDTO.class);

    }

    @Override
    public void add(QBoardDTO qBoardDTO){
        QBoardVO qBoardVO = modelMapper.map(qBoardDTO, QBoardVO.class);

        qBoardMapper.insert(qBoardVO);
    }


    @Override
    public void delete(Long qBoardNo) {
        QBoardVO qBoardVO = modelMapper.map(qBoardNo, QBoardVO.class);

        qBoardMapper.delete(qBoardVO.getQBoardNo());
    }

    /*게시물 하나 선택해서 삭제*/
    @Override
    public void deleteOne(Long qBoardDTO){

    }

    @Override
    public void selectOne(Long qBoardNo){
        Optional<QBoardVO> optionalBoardVO = qBoardMapper.selectOne(qBoardNo);
        QBoardVO qBoardVO = optionalBoardVO.orElseThrow();
        QBoardDTO qBoardDTO = new QBoardDTO();

    }

    @Override
    public void modify(QBoardDTO qBoardDTO){
        Optional<QBoardVO> optionalQBoardVO = qBoardMapper.modify(qBoardDTO.getQBoardNo());
        QBoardVO qBoardVO = optionalQBoardVO.orElseThrow();
        qBoardVO.change(qBoardVO.getTitle(), qBoardVO.getContent());
        qBoardMapper.modify(qBoardVO.getQBoardNo());

    }

    @Override
    public List<QBoardDTO> getAll() {
        List<QBoardVO> qBoardVOList = qBoardMapper.selectAll();
        List<QBoardDTO> qBoardDTOList = new ArrayList<>();
        qBoardVOList.forEach(qBoardVO -> qBoardDTOList.add(modelMapper.map(qBoardVO, QBoardDTO.class)));
        return qBoardDTOList;
    }

    @Override
    public PageResponseDTO<QBoardDTO> getList(PageRequestDTO pageRequestDTO) {
        List<QBoardVO> voList = qBoardMapper.selectList(pageRequestDTO);
        List<QBoardDTO> dtoList = new ArrayList<>();
        voList.forEach(vo -> dtoList.add(modelMapper.map(vo, QBoardDTO.class)));

        int total = qBoardMapper.getCount(pageRequestDTO);

        PageResponseDTO<QBoardDTO> pageResponseDTO = PageResponseDTO.<QBoardDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }




}
