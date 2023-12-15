package com.example.sbboard.repository;

import com.example.sbboard.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByWriter(String name);

    @Query("select b from Board b where b.content like %:keyword% " +
            "order by b.bno desc")
    List<Board> findByContentLike(@Param("keyword") String keyword);
    List<Board> findByContentContaining(String keyword);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Board b set b.visitcount = b.visitcount + 1 where b.bno = :bno")
    int updateVisitCount(@Param("bno") Long bno);

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "update Board b set b.visitcount = b.visitcount + 1 where b.bno = :bno", nativeQuery = true)
//    int updateVisitCount(@Param("bno") Long bno);
}
