package com.example.mentoring_project.service.mentoringService;

import com.example.mentoring_project.domain.mentoringVO.MentoringVO;
import com.example.mentoring_project.dto.mentoringDTO.MentoringDTO;
import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.mapper.mentoringMapper.MentoringMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MentoringServiceImpl implements MentoringService{
    private final MentoringMapper mentoringMapper;
    private final ModelMapper modelMapper;
    // 제발..
    @Override
    public void add(MentoringDTO mentoringDTO) {
        MentoringVO mentoringVO = modelMapper.map(mentoringDTO, MentoringVO.class);
        mentoringMapper.insert(mentoringVO);
    }

    @Override
    public List<MentoringDTO> getAll() {
        List<MentoringVO> mentoringVOList = mentoringMapper.selectAll();
        List<MentoringDTO> mentoringDTOList = new ArrayList<>();
        mentoringVOList.forEach(mentoringVO -> mentoringDTOList.add(modelMapper.map(mentoringVO, MentoringDTO.class)));
        return mentoringDTOList;
    }

    @Override
    public PageResponseDTO<MentoringDTO> getList(PageRequestDTO pageRequestDTO) {
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();

        List<MentoringVO> voList = mentoringMapper.selectList(pageRequestDTO);
        List<MentoringDTO> dtoList = new ArrayList<>();
        for (MentoringVO mentoringVO : voList) {
            dtoList.add(modelMapper.map(mentoringVO, MentoringDTO.class));
        }
        int total = mentoringMapper.getCount(pageRequestDTO);
        PageResponseDTO<MentoringDTO> pageResponseDTO = PageResponseDTO.<MentoringDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();
        return pageResponseDTO;
    }

    @Override
    public MentoringDTO getOne(Long mNo) {
        MentoringVO mentoringVO = mentoringMapper.selectOne(mNo);
        MentoringDTO mentoringDTO = modelMapper.map(mentoringVO, MentoringDTO.class);
        return mentoringDTO;
    }

    @Override
    public void modifyOne(MentoringDTO mentoringDTO) {
        MentoringVO mentoringVO = modelMapper.map(mentoringDTO, MentoringVO.class);
        mentoringMapper.update(mentoringVO);
    }

    @Override
    public void removeOne(Long mNo) {
        mentoringMapper.delete(mNo);
    }


}
