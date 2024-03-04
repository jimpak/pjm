package com.pjm.app07_board.service;

import com.pjm.app07_board.model.Board;
import com.pjm.app07_board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board saveBoard(Board board) {
        System.out.println("board title:" + board.getTitle() + "board content:" + board.getContent());
        return boardRepository.save(board);
    }

    public List<Board> getBoardList() {
        return boardRepository.findAll();
    }

    public void deleteBoard(Long num) {
        boardRepository.deleteById(num);
    }
}
