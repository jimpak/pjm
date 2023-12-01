package org.pjm.springexam03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.pjm.springexam03.dto.SampleDTO;

import java.util.List;

@Mapper
public interface SampleMapper {
    @Select("select now()")
    String getTime();


//    @Select("select * from tbl_sample")
    public List<SampleDTO> getList();

    public void insert(SampleDTO dto);

    public SampleDTO getDTO(int idx);

    public void update(SampleDTO dto);
    public void delete(int idx);
}
