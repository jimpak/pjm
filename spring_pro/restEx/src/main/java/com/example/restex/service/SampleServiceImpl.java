package com.example.restex.service;

import com.example.restex.service.SampleService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Data
@Log4j2
@Component
public class SampleServiceImpl implements SampleService {

    @Override
    public Integer doAdd(String str1, String str2) {
        try {
            int num1 = Integer.parseInt(str1);
            int num2 = Integer.parseInt(str2);
            return num1 + num2;
        } catch (NumberFormatException e) {
            // Handle the case where input strings are not valid integers
            log.error("Invalid input for addition: {} or {}", str1, str2, e);
            throw new IllegalArgumentException("Invalid input for addition");
        }
    }

    @Override
    public int doSub(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int doMul(int num1, int num2) {
        return num1 * num2;
    }
}