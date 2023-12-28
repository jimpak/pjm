package com.example.sb02.service;

import com.example.sb02.dto.CommentRequestDTO;
import com.example.sb02.dto.CommentResponseDTO;
import com.example.sb02.model.Board;
import com.example.sb02.model.Comment;
import com.example.sb02.repository.BoardRepository;
import com.example.sb02.repository.CommentRepository;
import com.example.sb02.repository.CommentRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentServiceImpl implements CommentService {

    private final CommentRepositoryCustom commentRepositoryCustom;
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    @Override
    public void create(CommentRequestDTO commentRequestDTO) {
        Comment comment = new Comment(commentRequestDTO);

        Optional<Board> result = boardRepository.findById(commentRequestDTO.getBoardId());

        if (result.isPresent()) {
            Board board = result.get();
            comment.setBoard(board);
        }
        if (commentRequestDTO.getParentId() != null) {
            Optional<Comment> parent = commentRepository.findById(commentRequestDTO.getParentId());
            if (parent.isPresent()) {
                parent.get().setChild(comment);
                commentRepositoryCustom.updateLeftRight(comment);
                commentRepository.save(comment);
            }
        } else {
            commentRepository.save(comment);
            comment.setRootId(comment);
        }
    }

    @Override
    public void delete(Long cno) {
        Optional<Comment> comment = commentRepository.findById(cno);
        if (comment.isPresent()) {
            commentRepository.deleteById(cno);
        }
    }

    @Override
    public List<CommentResponseDTO> findAll(Long boardId) {
        return commentRepositoryCustom.findCommentByBoardId(boardId);
    }
}
