package org.pjm.boardsystem.service;

import org.pjm.boardsystem.dto.BoardDTO;
import org.pjm.boardsystem.dto.PageRequestDTO;
import org.pjm.boardsystem.dto.PageResponseDTO;
import org.pjm.boardsystem.vo.BoardAttachVO;

import java.util.List;

public interface BoardService {

    List<BoardDTO> getList();
    int register(BoardDTO boardDTO);
    BoardDTO view(int bno);
    int modify(BoardDTO boardDTO);
    int remove(int bno);
    int totalCount();

    PageResponseDTO<BoardDTO> getPagingList(PageRequestDTO pageRequestDTO);

    List<BoardAttachVO> attachList(int bno);
}
