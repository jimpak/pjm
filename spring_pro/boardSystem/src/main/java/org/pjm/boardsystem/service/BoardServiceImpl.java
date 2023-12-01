package org.pjm.boardsystem.service;

import lombok.RequiredArgsConstructor;
import org.pjm.boardsystem.dto.BoardDTO;
import org.pjm.boardsystem.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getList() {
        return boardMapper.getList();
    }
}
