package com.example.sb02.repository;

import com.example.sb02.model.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
    @Query("select f from UploadFile f where f.board.bno=:bno")
    List<UploadFile> findByBoardList(Long bno);
}
