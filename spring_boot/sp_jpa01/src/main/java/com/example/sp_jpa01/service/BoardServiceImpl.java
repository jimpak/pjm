package com.example.sp_jpa01.service;

import com.example.sp_jpa01.model.Board;
import com.example.sp_jpa01.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board register(Board board) {
        Board board1 = boardRepository.save(board);
        return board1;
    }

    @Override
    public List<Board> getList() {
        return boardRepository.findAll();
    }

    @Override
    public Board getBoard(Long bno) {
        Optional<Board> optionalBoard = boardRepository.findById(bno);
        Board board = optionalBoard.get();
        return board;
    }

//    @Override
//    public Board getBoard(Long bno) {
//        return boardRepository.findById(bno).get();
//    }

    @Override
    public Board modify(Board board) {
        Board board1 = boardRepository.findById(board.getBno()).get();
        board1.setTitle(board.getTitle());
        board1.setContent(board.getContent());
        return boardRepository.save(board1);
    }

    @Override
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }
}
