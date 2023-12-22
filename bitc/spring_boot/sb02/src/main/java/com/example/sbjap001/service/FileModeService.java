package com.example.sbjap001.service;

import com.example.sbjap001.domain.FileModel;
import com.example.sbjap001.dto.upload.UploadResultDTO;

import java.util.List;

public interface FileModeService {
    Long register(FileModel fileModel);
    List<UploadResultDTO> getList(Long bno);
    void remove(Long fno);
    UploadResultDTO get(Long fno);
}
