package com.example.restex.service;

import com.example.restex.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    int register(ReplyDTO dto);
    ReplyDTO read(int rno);
    int modify(ReplyDTO dto);
    int remove(int rno);
    List<ReplyDTO> getList(int bno);
}
