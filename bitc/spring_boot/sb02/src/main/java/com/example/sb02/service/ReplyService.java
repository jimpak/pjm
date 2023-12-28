package com.example.sb02.service;

import com.example.sb02.dto.PageRequestDTO;
import com.example.sb02.dto.PageResponseDTO;
import com.example.sb02.dto.ReplyDTO;

public interface ReplyService {
    Long register(ReplyDTO dto);
    ReplyDTO read(Long rno);
    void modify(ReplyDTO replyDTO);
    void remove(Long rno);

    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);

}
