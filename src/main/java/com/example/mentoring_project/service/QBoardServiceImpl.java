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
    public void delete(Long QBoardDTO) {
        QBoardVO qBoardVO = modelMapper.map(QBoardDTO, QBoardVO.class);

        qBoardMapper.delete(qBoardVO);
    }

    /*게시물 하나 선택해서 삭제*/
    @Override
    public void deleteOne(Long qBoardNo){
        qBoardMapper.deleteOne(qBoardNo);
    }

    @Override
    public QBoardDTO selectOne(Long qBoardNo){
        QBoardVO qBoardVO = qBoardMapper.selectOne(qBoardNo);
        QBoardDTO qBoardDTO = modelMapper.map(qBoardVO, QBoardDTO.class);
        return qBoardDTO;

    }

    @Override
    public void modify(QBoardDTO qBoardDTO){
        QBoardVO qBoardVO = modelMapper.map(qBoardDTO, QBoardVO.class);
        qBoardMapper.update(qBoardVO);
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
