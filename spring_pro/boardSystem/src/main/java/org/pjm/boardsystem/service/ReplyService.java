package org.pjm.boardsystem.service;

import org.pjm.boardsystem.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {
    int register(ReplyDTO dto);
    ReplyDTO read(int rno);
    int modify(ReplyDTO dto);
    int remove(int rno);
    List<ReplyDTO> getList(int bno);
}
