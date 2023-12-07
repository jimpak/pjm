package com.example.restex.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Log4j2
@Aspect
@Component
public class LogAdvice {
    @Before("execution(* com.example.restex.service.SampleServiceImpl.doAdd(..))")
    public void logBefore() {
        log.info("================================");
        log.info("Before method execution");
    }

    @AfterThrowing(pointcut = "execution(* com.example.restex.service.SampleServiceImpl.doAdd(..))",
            throwing = "exception")
    public void logException(Exception exception) {
        log.error("Exception occurred: {}", exception.getMessage());
        log.error("Exception details:", exception);
    }

    @Around("execution(* com.example.restex.service.SampleService*.*(..))")
    public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("Target: {}", pjp.getTarget());
        log.info("Method: {}", pjp.getSignature().toShortString());
        log.info("Params: {}", Arrays.toString(pjp.getArgs()));

        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            log.error("Exception during method execution: {}", e.getMessage());
            throw e;
        }

        long end = System.currentTimeMillis();
        log.info("Execution Time: {} ms", (end - start));
        log.info("================================");
        return result;
    }
}
