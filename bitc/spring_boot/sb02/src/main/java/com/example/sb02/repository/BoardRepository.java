package com.example.sb02.repository;

import com.example.sb02.model.Board;

import com.example.sb02.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long>, BoardSearch {
    //여기에 아무 작업을 안해도 기본적인 crud는 된다.
    List<Board> findByWriter(String name);
    Page<Board> findByTitleContainingOrderByBnoDesc(String keyword, Pageable pageable);

    @Query("SELECT b from Board b where b.title like concat('%',:keyword,'%')order by b.bno desc")
    Page<Board> findByKeyword(String keyword,Pageable pageable);


//    List<Board> findByContentLike(String keyword);

    //@Query
    //Board getBoard(Long bno);
//    @Modifying
//    @Query("update Board b set b.visitcount=b.visitcount+1 where b.bno =: bno")
//    //@Query(value="update Board b set b.visitcount=b.visitcount+1 where b.bno=:bno", nativeQuery = true)
//    void updateByVisitcount(@Param("bno") Long bno);
//
//    @Query("select b from Board b where b.content like %:keyword% order by b.bno desc")
//    List<Board> findByContentLike(@Param("keyword") String keyword);
//    List<Board> findByContentContainingOrderByBno(String keyword);
//    List<Board> findByTitleOrContent(String keyword);
//
//    //public List<Board> getByContentLike(String keyword);


}
