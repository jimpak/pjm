package org.pjm.springexam03.service;

import org.pjm.springexam03.dto.SampleDTO;

import java.util.List;

public interface SampleService {
    List<SampleDTO> getList();
    void insert(SampleDTO dto);

    SampleDTO getDTO(int idx);

    void modify(SampleDTO sampleDTO);

    void remove(int idx);
}
