package com.example.restex.service;

import com.example.restex.service.SampleService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class AopTest {

    @Autowired
    private SampleService sampleService;

    @Test
    public void testAop() {
        log.info("SampleService bean: {}", sampleService);
        log.info("doAdd result: {}", sampleService.doAdd("11", "10"));
        log.info("doSub result: {}", sampleService.doSub(11, 10));
        log.info("doMul result: {}", sampleService.doMul(11, 10));
    }

    @Test
    public void aopTest2() {
        log.info("Invalid input test result: {}", sampleService.doAdd("11", "aa"));
    }

    @Test
    public void aopTest3() {
        log.info("doAdd result: {}", sampleService.doAdd("11", "10"));
        log.info("doSub result: {}", sampleService.doSub(11, 10));
        log.info("doMul result: {}", sampleService.doMul(11, 10));
    }
}