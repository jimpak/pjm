package com.example.restex.mapper;

import com.example.restex.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public int insertReply(ReplyVO vo);
    public ReplyVO readReply(int rno);
    public int updateReply(ReplyVO vo);
    public int deleteReply(int rno);
    public List<ReplyVO> getListReply(int bno);
}
