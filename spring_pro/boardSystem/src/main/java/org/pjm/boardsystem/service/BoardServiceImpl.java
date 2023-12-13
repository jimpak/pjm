package org.pjm.boardsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.pjm.boardsystem.dto.BoardDTO;
import org.pjm.boardsystem.dto.PageRequestDTO;
import org.pjm.boardsystem.dto.PageResponseDTO;
import org.pjm.boardsystem.mapper.AttachMapper;
import org.pjm.boardsystem.mapper.BoardMapper;
import org.pjm.boardsystem.vo.BoardAttachVO;
import org.pjm.boardsystem.vo.BoardVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;
    private final AttachMapper attachMapper;

    @Override
    public List<BoardDTO> getList() {
        List<BoardDTO> boardDTOList = boardMapper.getBoardList().stream()
                .map(vo->modelMapper.map(vo, BoardDTO.class))
                .collect(Collectors.toList());
        return boardDTOList;
    }

    @Transactional
    @Override
    public int register(BoardDTO boardDTO) {
        log.info("service register:" + boardDTO);
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        int result = boardMapper.insertBoard(boardVO);
        System.out.println("result = " + result);
        int bno = boardMapper.getBno();
        if(boardDTO.getAttachVOList() != null || boardDTO.getAttachVOList().size() > 0) {
            boardDTO.getAttachVOList().forEach(attach -> {
                attach.setBno(bno);
                attachMapper.insertAttach(attach);
            });
        }
        return result;
    }

    @Override
    public BoardDTO view(int bno) {
        BoardVO boardVO = boardMapper.get(bno);
        BoardDTO boardDTO = modelMapper.map(boardVO, BoardDTO.class);

        boardDTO.setAttachVOList(attachMapper.findByBno(bno));

        if(boardDTO != null) {
            boardMapper.visitcountUpdate(bno);
        }

        return boardDTO;
    }

    @Transactional
    @Override
    public int modify(BoardDTO boardDTO) {
//        if(boardDTO.getAttachVOList() == null){
//            List<BoardAttachVO> attachVOList = attachMapper.findByBno(boardDTO.getBno());
//            boardDTO.setAttachVOList(attachVOList);
//        }

        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        int result = boardMapper.updateBoard(boardVO);

        if(boardDTO.getAttachVOList() != null) {
            attachMapper.deleteAll(boardVO.getBno());
        }

        if(result == 1 && boardDTO.getAttachVOList().size() > 0) {
            boardDTO.getAttachVOList().forEach(attach -> {
                attach.setBno(boardDTO.getBno());
                attachMapper.insertAttach(attach);
            });
        }
        log.info("service modify: result=" + result);
        return result;
    }

    @Transactional
    @Override
    public int remove(int bno) {
        attachMapper.deleteAll(bno);
        int result = boardMapper.deleteBoard(bno);
        log.info("service remove: result=" + result);
        return result;
    }

    @Override
    public int totalCount() {
        return boardMapper.totalCount();
    }

    @Override
    public PageResponseDTO<BoardDTO> getPagingList(PageRequestDTO pageRequestDTO) {
        log.info("service" + pageRequestDTO);
        List<BoardVO> voList = boardMapper.pagingList(pageRequestDTO);
        List<BoardDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo, BoardDTO.class))
                .collect(Collectors.toList());

        int total = boardMapper.pageCount(pageRequestDTO);

        PageResponseDTO<BoardDTO> pageResponseDTO = PageResponseDTO
                .<BoardDTO>withAll()
                .dtoList(dtoList)
                .total(total)
                .pageRequestDTO(pageRequestDTO)
                .build();

        return pageResponseDTO;
    }

    @Override
    public List<BoardAttachVO> attachList(int bno) {
        return attachMapper.findByBno(bno);
    }


}
