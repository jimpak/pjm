package org.pjm.springexam02.mapper;

import org.apache.ibatis.annotations.Select;
import org.pjm.springexam02.dto.SampleDTO;

import java.util.List;

public interface SampleMapper {
    @Select("select now()")
    String getTime();


//    @Select("select * from tbl_sample")
    public List<SampleDTO> getList();

    public void insert(SampleDTO dto);

    public SampleDTO getDTO(int idx);

    public void modify(SampleDTO dto);
    public void del(int idx);
}
