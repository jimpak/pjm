package com.example.sbjap001.service;

import com.example.sbjap001.domain.UploadFile;
import com.example.sbjap001.dto.UploadResultDTO;

import java.util.List;

public interface UploadFileService {
    Long register(UploadFile uploadFile);
    List<UploadResultDTO> getList(Long bno);
    void remove(Long fno);
    UploadResultDTO get(Long fno);
}
