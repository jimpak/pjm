package com.example.sb02.service;

import com.example.sb02.dto.PageRequestDTO;
import com.example.sb02.dto.PageResponseDTO;
import com.example.sb02.dto.ReplyDTO;
import com.example.sb02.model.Board;
import com.example.sb02.model.Reply;
import com.example.sb02.repository.BoardRepository;
import com.example.sb02.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public Long register(ReplyDTO dto) {
        Reply reply = modelMapper.map(dto, Reply.class);
        Board board = Board.builder().bno(dto.getBno()).build(); // 동적쿼리 쓰는 방식
//        Board board = boardRepository.findById(dto.getBno()).get(); //동적쿼리 안쓰는 방식
//        board.updateReplycount();
//        boardRepository.save(board);
        reply.setBoard(board);
        Long rno = replyRepository.save(reply).getRno();
        return rno;
    }

    @Override
    public ReplyDTO read(Long rno) {
        Optional<Reply> result = replyRepository.findById(rno);
        Reply reply = result.get();
        ReplyDTO dto = modelMapper.map(reply, ReplyDTO.class);
        return dto;
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Reply reply = replyRepository.findById(replyDTO.getRno()).get();
        reply.changeText(replyDTO.getReplytext());
        replyRepository.save(reply);
    }

    @Override
    public void remove(Long rno) {
        replyRepository.deleteById(rno);
    }

    @Override
    public PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO) {
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1,
                pageRequestDTO.getSize(),
                Sort.by("rno").descending());

        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);
        List<ReplyDTO> dtoList = result.getContent().stream()
                .map(reply -> modelMapper.map(reply, ReplyDTO.class))
                .collect(Collectors.toList());

        return PageResponseDTO
                .<ReplyDTO>withAll().pageRequestDTO(pageRequestDTO).dtoList(dtoList).total((int) result.getTotalElements()).build();
    }
}
