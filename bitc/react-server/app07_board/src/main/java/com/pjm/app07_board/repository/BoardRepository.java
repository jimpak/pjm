package com.pjm.app07_board.repository;

import com.pjm.app07_board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
