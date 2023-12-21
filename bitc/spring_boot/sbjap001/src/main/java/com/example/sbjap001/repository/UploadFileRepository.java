package com.example.sbjap001.repository;

import com.example.sbjap001.domain.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
    @Query("select f from UploadFile f where f.board.bno=:bno")
    List<UploadFile> findByBoardList(Long bno);
}

