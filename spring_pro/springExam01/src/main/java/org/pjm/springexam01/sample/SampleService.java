package org.pjm.springexam01.sample;

import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
//@AllArgsConstructor
public class SampleService {
    @Autowired
    private SampleDAO sampleDAO;
//    private final SampleDAO sampleDAO;
    @Autowired
    private ISampleDAO iSampleDAO1;
    @Autowired
    @Qualifier("normal")
    private ISampleDAO iSampleDAO2;
}
