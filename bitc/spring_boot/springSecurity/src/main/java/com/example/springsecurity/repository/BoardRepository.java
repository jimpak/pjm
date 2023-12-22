package com.example.springsecurity.repository;

import com.example.springsecurity.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
