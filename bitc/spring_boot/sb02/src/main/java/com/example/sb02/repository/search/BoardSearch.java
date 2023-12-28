package com.example.sb02.repository.search;

import com.example.sb02.dto.BoardListReplyCountDTO;
import com.example.sb02.model.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<Board> search1(Pageable pageable);
    Page<Board>searchAll(String[] type, String keyword, Pageable pageable);
    Page<BoardListReplyCountDTO> searchWithReplyCount(String[] types, String keyword, Pageable pageable);
}
