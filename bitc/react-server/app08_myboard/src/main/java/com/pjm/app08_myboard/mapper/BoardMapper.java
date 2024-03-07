package com.pjm.app08_myboard.mapper;

import com.pjm.app08_myboard.dto.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from board order by num desc")
    List<Board> getList();
    @Insert("insert into board(title, content) values (#{title},#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "num")
    void insert(Board board);
    @Delete("delete from board where num=#{num}")
    Long delete(Long num);
}
