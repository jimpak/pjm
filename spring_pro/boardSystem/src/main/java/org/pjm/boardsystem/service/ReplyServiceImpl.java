package org.pjm.boardsystem.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.pjm.boardsystem.dto.ReplyDTO;
import org.pjm.boardsystem.mapper.ReplyMapper;
import org.pjm.boardsystem.vo.ReplyVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyMapper replyMapper;
    private final ModelMapper modelMapper;

    @Override
    public int register(ReplyDTO dto) {
        ReplyVO vo = modelMapper.map(dto, ReplyVO.class);
        int result = replyMapper.insertReply(vo);
        return result;
    }

    @Override
    public ReplyDTO read(int rno) {
        ReplyVO vo = replyMapper.readReply(rno);
        ReplyDTO dto = modelMapper.map(vo, ReplyDTO.class);
        return dto;
    }

    @Override
    public int modify(ReplyDTO dto) {
        ReplyVO vo = modelMapper.map(dto, ReplyVO.class);
        int result = replyMapper.updateReply(vo);
        return result;
    }

    @Override
    public int remove(int rno) {
        return replyMapper.deleteReply(rno);
    }

    @Override
    public List<ReplyDTO> getList(int bno) {
        List<ReplyVO> voList = replyMapper.getListReply(bno);
        List<ReplyDTO> dtoList = voList.stream()
                .map(vo->modelMapper.map(vo, ReplyDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
}
