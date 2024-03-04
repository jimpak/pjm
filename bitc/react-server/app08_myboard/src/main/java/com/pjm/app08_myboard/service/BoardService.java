package com.pjm.app08_myboard.service;

import com.pjm.app08_myboard.dto.Board;
import com.pjm.app08_myboard.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Board> getList() {
        return boardMapper.getList();
    }

    public void insert(Board board) {
        boardMapper.insert(board);
    }

    public Long delete(Long num) {
        return boardMapper.delete(num);
    }
}
