package com.example.sbjap001.service;

import com.example.sbjap001.domain.Board;
import com.example.sbjap001.domain.UploadFile;
import com.example.sbjap001.dto.UploadResultDTO;
import com.example.sbjap001.repository.UploadFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class UploadFileServiceImpl implements UploadFileService {

    private final UploadFileRepository uploadFileRepository;

    @Override
    public Long register(UploadFile uploadFile) {
        Board board = Board.builder().bno(uploadFile.getBoard().getBno()).build();
        uploadFile.setBoard(board);
        Long fno = uploadFileRepository.save(uploadFile).getFno();
        return fno;
    }

    @Override
    public List<UploadResultDTO> getList(Long bno) {
        List<UploadFile> fileList = uploadFileRepository.findByBoardList(bno);

        return fileList;
    }

    @Override
    public void remove(Long fno) {
        uploadFileRepository.deleteById(fno);
    }

    @Override
    public UploadResultDTO get(Long fno) {
        UploadFile uploadFile = uploadFileRepository.findById(fno).get();
        UploadResultDTO resultDTO = UploadResultDTO.builder()
                .filename(uploadFile.getFilename())
                .uuid(uploadFile.getUuid())
                .image(uploadFile.isImage())
                .build();
        return resultDTO;
    }
}
