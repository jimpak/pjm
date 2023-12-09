package org.pjm.springexam03.service;

import lombok.RequiredArgsConstructor;
import org.pjm.springexam03.dto.SampleDTO;
import org.pjm.springexam03.mapper.SampleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService{
    //@Autowired
    private final SampleMapper sampleMapper;
    @Override
    public List<SampleDTO> getList() {
        return sampleMapper.getList();
    }

    @Override
    public void insert(SampleDTO dto) {
        sampleMapper.insert(dto);
    }

    @Override
    public SampleDTO getDTO(int idx) {
        return sampleMapper.getDTO(idx);
    }

    @Override
    public void modify(SampleDTO sampleDTO) {
        sampleMapper.update(sampleDTO);
    }

    @Override
    public void remove(int idx) {
        sampleMapper.delete(idx);
    }
}
