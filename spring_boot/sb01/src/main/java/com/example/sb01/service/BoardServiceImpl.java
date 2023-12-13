package com.example.sb01.service;

import com.example.sb01.dto.BoardDTO;
import com.example.sb01.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
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

    @Override
    public int register(BoardDTO dto) {
        return 0;
    }

    @Override
    public BoardDTO getBoard(int bno) {
        return null;
    }

    @Override
    public int modify(BoardDTO dto) {
        return 0;
    }

    @Override
    public int remove(int bno) {
        return 0;
    }
}
