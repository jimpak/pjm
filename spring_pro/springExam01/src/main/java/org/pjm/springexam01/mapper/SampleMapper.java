package org.pjm.springexam01.mapper;

import org.apache.ibatis.annotations.Select;
import org.pjm.springexam01.dto.SampleDTO;

import java.util.List;

public interface SampleMapper {
    @Select("select now()")
    String getTime();


//    @Select("select * from tbl_sample")
    public List<SampleDTO> getList();

}
