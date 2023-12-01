package org.pjm.boardsystem.service;

import org.pjm.boardsystem.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getList();
}
