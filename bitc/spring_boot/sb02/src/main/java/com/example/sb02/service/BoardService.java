package com.example.sb02.service;

import com.example.sb02.dto.BoardDTO;
import com.example.sb02.dto.BoardListReplyCountDTO;
import com.example.sb02.dto.PageRequestDTO;
import com.example.sb02.dto.PageResponseDTO;
import com.example.sb02.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    Long register(BoardDTO boardDTO);
    List<BoardDTO> getList(Pageable pageable);
    BoardDTO getBoard(Long bno);
    Long modify(BoardDTO boardDTO);
    void remove(Long bno);
    PageResponseDTO<BoardDTO> listDsl(PageRequestDTO pageRequestDTO);
    PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);


//    Long totalCount();
//    List<BoardDTO> getByWriter(String writer);
//    List<BoardDTO> getByContent(String keyword);
    //List<Board> getByTitleContent(String keyword);
}
