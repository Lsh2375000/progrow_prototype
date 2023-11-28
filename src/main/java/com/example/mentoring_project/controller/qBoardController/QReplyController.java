package com.example.mentoring_project.controller.qBoardController;

import com.example.mentoring_project.dto.pageDTO.PageRequestDTO;
import com.example.mentoring_project.dto.pageDTO.PageResponseDTO;
import com.example.mentoring_project.dto.qBoardDTO.QReplyDTO;
import com.example.mentoring_project.service.qBoardService.QReplyService;
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

@RestController
@RequestMapping("/qReplies")
@Log4j2
@RequiredArgsConstructor // 의존성 주입을 위해
public class QReplyController {
    private final QReplyService qReplyService;

    @ApiOperation(value = "QReplies POST", notes = "POST 방식으로 댓글 등록")
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> register(@Valid @RequestBody QReplyDTO qReplyDTO, BindingResult bindingResult) throws BindException {
        log.info(qReplyDTO);

        if (bindingResult.hasErrors()) {
            throw new BindException((bindingResult));
        }

        Map<String, Long> resultMap = new HashMap<>();
        Long qRno = qReplyService.addReplyQ(qReplyDTO);
        resultMap.put("qRno", qRno);

        return resultMap;
    }

    @ApiOperation(value = "QReplies of QBoard", notes = "GET 방식으로 특정 게시물의 댓글 목록")
    @GetMapping(value = "/list/{qBoardNo}")
    public PageResponseDTO<QReplyDTO> getListQ(@PathVariable("qBoardNo") Long qBoardNo, PageRequestDTO pageRequestDTO) {
        // @PathVariable 경로에 있는 값 사용
        PageResponseDTO<QReplyDTO> responseDTO = qReplyService.getListOfBoardQ(qBoardNo, pageRequestDTO);

        return responseDTO;
    }

    @ApiOperation(value = "Read QReply", notes = "GET 방식으로 특정 댓글 조회")
    @GetMapping(value = "/{qRno}")
    public QReplyDTO getReplyDTO(@PathVariable("qRno") Long qRno) {
        QReplyDTO qReplyDTO = qReplyService.read(qRno);
        return qReplyDTO;
    }

    @ApiOperation(value = "Delete QReply", notes = "DELETE 방식으로 특정 댓글 삭제")
    @DeleteMapping("/{qRno}")
    public Map<String, Long> remove(@PathVariable("qRno") Long qRno) {
        qReplyService.removeOne(qRno);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("qRno", qRno);
        return resultMap;
    }

    @ApiOperation(value = "QReplies PUT", notes = "PUT 방식으로 댓글 수정")
    @PutMapping(value = "/{qRno}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Long> modify(@PathVariable("qRno") Long qRno, @RequestBody QReplyDTO qReplyDTO) {
        qReplyDTO.setQRno(qRno);

        qReplyService.modifyOne(qReplyDTO);
        Map<String, Long> resultMap = new HashMap<>();
        resultMap.put("qRno", qRno);

        return resultMap;
    }
}
