package com.example.sp_jpa01.repository;

import com.example.sp_jpa01.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> { // JpaRepository<Entity, Id의 형>
}
