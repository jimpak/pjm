package com.example.sbjap001.repository;

import com.example.sbjap001.domain.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileModelRepository extends JpaRepository<FileModel, Long> {
    @Query("select f from UploadFile f where f.board.bno=:bno")
    List<FileModel> findFileListBno(Long bno);

}
