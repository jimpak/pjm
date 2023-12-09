//package org.pjm.springexam01;
//
//import lombok.extern.log4j.Log4j2;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.pjm.springexam01.dto.SampleDTO;
//import org.pjm.springexam01.sample.SampleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@Log4j2
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(locations = "classpath:/root-context01.xml")
//public class SampleTest {
//    private SampleDTO sampleDTO;
//    @Autowired
//    @Qualifier("dto2")
//    private SampleDTO sampleDTO1;
//    @Autowired
//    private SampleService sampleService;
//
//    @Test
//    public void test3() {
//        log.info(sampleService);
//    }
//
//    @Test
//    public void test2() {
//        log.info(sampleDTO1);
//    }
//
//    @Test
//    public void test1() {
//        sampleDTO = new SampleDTO();
//        sampleDTO.setAge(20);
//        sampleDTO.setName("홍길동");
//        log.info(sampleDTO);
//    }
//}
