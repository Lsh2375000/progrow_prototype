package com.example.mentoring_project.service.memberService;


import com.example.mentoring_project.domain.memberVO.MentorVO;
import com.example.mentoring_project.dto.memberDTO.MentorDTO;
import com.example.mentoring_project.mapper.memberMapper.MentorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class MentorServiceImpl implements MentorService{
    private final MentorMapper mentorMapper;
    private final ModelMapper modelMapper;

    @Value("${com.example.upload.path}")
    private String uploadPath;

    @Override
    public void add(MentorDTO mentorDTO, List<MultipartFile> files) {
        log.info("MentorService add()...");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        mentorDTO.setPasswd(passwordEncoder.encode(mentorDTO.getPasswd()));
        StringBuilder str = new StringBuilder();
        for(MultipartFile file : files) {
            String uuid = UUID.randomUUID().toString();
            Path savePath = Paths.get(uploadPath, uuid + "_" + file.getOriginalFilename());
            str.append(uuid).append("_").append(file.getOriginalFilename()).append("|");
            try {
                file.transferTo(savePath);
            } catch (IOException e){
                log.error(e.getMessage());
            }
        }
        mentorDTO.setFileNames(str.toString());
        log.info("입력된 첨부파일 : " + str.toString());
        MentorVO mentorVO = modelMapper.map(mentorDTO, MentorVO.class);

        mentorMapper.insert(mentorVO);
    }

    @Override
    public List<MentorDTO> getAll() {
        log.info("MentorService getAll()...");

        List<MentorVO> mentorVOList = mentorMapper.selectAll();
        List<MentorDTO> mentorDTOList = new ArrayList<>();
        mentorVOList.forEach(mentorVO -> mentorDTOList.add(modelMapper.map(mentorVO, MentorDTO.class)));
        return mentorDTOList;
    }



    @Override
    public MentorDTO getOne(String mentor_id) {
        log.info("MentorService getOne()...");

        MentorVO mentorVO = mentorMapper.selectOne(mentor_id);
        MentorDTO mentorDTO = modelMapper.map(mentorVO, MentorDTO.class);
        return mentorDTO;
    }


    @Override
    public void modify(MentorDTO mentorDTO, List<MultipartFile> files) {
        log.info("MentorService modify()...");
        log.info(files);
        StringBuilder str = new StringBuilder();
        MentorDTO mentorDTO1 = getOne(mentorDTO.getMentor_id());
        str.append(mentorDTO1.getFileNames());
        for(MultipartFile file : files) {
            String uuid = UUID.randomUUID().toString();
            Path savePath = Paths.get(uploadPath, uuid + "_" + file.getOriginalFilename());
            str.append(uuid).append("_").append(file.getOriginalFilename()).append("|");
            try {
                file.transferTo(savePath);
            } catch (IOException e){
                log.error(e.getMessage());
            }
        }


        mentorDTO.setFileNames(str.toString());
        MentorVO mentorVO = modelMapper.map(mentorDTO, MentorVO.class);
        mentorMapper.update(mentorVO);
    }



    @Override
    public void remove(String mentor_id) {
        log.info("MentorService remove()....");
        mentorMapper.delete(mentor_id);
    }

    @Override
    public void modifyPw(String passwd, String mentor_id) {
        log.info("Mentor Service ModifyPw()...");
        mentorMapper.updatePw(passwd, mentor_id);
    }
}
