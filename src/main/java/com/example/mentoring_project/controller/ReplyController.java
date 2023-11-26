package com.example.mentoring_project.controller;

import com.example.mentoring_project.dto.PageRequestDTO;
import com.example.mentoring_project.dto.PageResponseDTO;
import com.example.mentoring_project.dto.ReplyDTO;
import com.example.mentoring_project.service.ReplyService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/replies")
@Log4j2
public class ReplyController {

    private final ReplyService replyService;

    @ApiOperation(value = "Replies POST", notes = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(@Valid @RequestBody ReplyDTO replyDTO, BindingResult bindingResult) throws BindException {
        log.info(replyDTO);

        if(bindingResult.hasErrors()){
            throw  new BindException((bindingResult));
        }

        Map<String, Long> resultMap = new HashMap<>();
        Long rno = replyService.register(replyDTO);

        resultMap.put("rno", rno);
        return resultMap;
    }

    @ApiOperation(value = "boardReply", notes = "GET 방식으로 게시물의 댓글 목록을 보여줌")
    @GetMapping(value = "/list/{boardNo}")
    public PageResponseDTO<ReplyDTO> getList(@PathVariable("boardNo")int boardNo, PageRequestDTO pageRequestDTO){
        PageResponseDTO<ReplyDTO> responseDTO = replyService.getList(boardNo, pageRequestDTO);
        return responseDTO;
    }

    @ApiOperation(value = "read Reply", notes = "GET 방식으로 특정 댓글 조회")
    @GetMapping(value = "{/rno}")
    public ReplyDTO getReplyDTO(@PathVariable("rno") Long rno){
        ReplyDTO replyDTO = replyService.read(rno);
        return replyDTO;
    }

    @ApiOperation(value = "Reply Modify", notes = "PUT 방식으로 댓글 수정")
    @PutMapping(value = "{/rno}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> modify(@PathVariable("rno") Long rno, @RequestBody ReplyDTO replyDTO){
        replyDTO.setRno(rno);
        replyService.modify(replyDTO);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", rno);
        return resultMap;
    }

    @ApiOperation(value = "reply delete", notes = "Delete 방식으로 댓글 삭제")
    @DeleteMapping(value = "/{rno}")
    public Map<String, Long> remove(@PathVariable("rno") Long rno){
        replyService.remove(rno);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("rno", rno);
        return resultMap;
    }






}
