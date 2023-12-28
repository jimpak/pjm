package com.example.sb02.service;

import com.example.sb02.dto.BoardDTO;
import com.example.sb02.dto.upload.UploadResultDTO;
import com.example.sb02.model.UploadFile;

import java.util.List;

public interface UploadFileService {
    Long register(UploadFile uploadFile);
    List<UploadResultDTO>getList(Long bno);
    void remove(Long bno);
    UploadResultDTO get (Long fno);

}
