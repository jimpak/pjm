package com.example.sbjap001.service;

import com.example.sbjap001.domain.Board;
import com.example.sbjap001.domain.FileModel;
import com.example.sbjap001.dto.upload.UploadResultDTO;
import com.example.sbjap001.repository.FileModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileModelServiceImpl implements FileModeService{
    private final FileModelRepository fileModelRepository;
    @Override
    public Long register(FileModel fileModel) {
        Board board=Board.builder().bno(fileModel.getBoard().getBno()).build();
        fileModel.setBoard(board);
        Long fno=fileModelRepository.save(fileModel).getFno();
        return fno;
    }

    @Override
    public List<UploadResultDTO> getList(Long bno) {
        List<FileModel> modelList=fileModelRepository.findFileListBno(bno);
        List<UploadResultDTO> resultDTOList=new ArrayList<>();
        modelList.forEach(fileModel -> {
            UploadResultDTO resultDTO=UploadResultDTO.builder()
                    .filename(fileModel.getFilename())
                    .uuid(fileModel.getUuid())
                    .image(fileModel.isImage())
                    .build();
            resultDTOList.add(resultDTO);
        });
        return resultDTOList;
    }

    @Override
    public void remove(Long fno) {
        fileModelRepository.deleteById(fno);
    }

    @Override
    public UploadResultDTO get(Long fno) {
        FileModel fileModel=fileModelRepository.findById(fno).get();
        UploadResultDTO resultDTO=UploadResultDTO.builder()
                        .filename(fileModel.getFilename())
                        .uuid(fileModel.getUuid())
                        .image(fileModel.isImage()).build();

        return resultDTO;
    }
}
