package org.pjm.boardsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.pjm.boardsystem.dto.BoardDTO;
import org.pjm.boardsystem.dto.PageRequestDTO;
import org.pjm.boardsystem.dto.PageResponseDTO;
import org.pjm.boardsystem.mapper.BoardMapper;
import org.pjm.boardsystem.vo.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;

    @Override
    public List<BoardDTO> getList() {
        List<BoardDTO> boardDTOList = boardMapper.getBoardList().stream()
                .map(vo->modelMapper.map(vo, BoardDTO.class))
                .collect(Collectors.toList());
        return boardDTOList;
    }

    @Override
    public int register(BoardDTO boardDTO) {
        log.info("service register:" + boardDTO);
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        int result = boardMapper.insertBoard(boardVO);
        return result;
    }

    @Override
    public BoardDTO view(int bno) {
        BoardVO boardVO = boardMapper.get(bno);
        BoardDTO boardDTO = modelMapper.map(boardVO, BoardDTO.class);
        if(boardDTO != null) {
            boardMapper.visitcountUpdate(bno);
        }

        return boardDTO;
    }

    @Override
    public int modify(BoardDTO boardDTO) {
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        int result = boardMapper.updateBoard(boardVO);
        log.info("service modify: result=" + result);
        return result;
    }

    @Override
    public int remove(int bno) {
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


}
