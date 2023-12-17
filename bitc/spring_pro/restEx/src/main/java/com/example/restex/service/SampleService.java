package com.example.restex.service;

import org.springframework.stereotype.Component;

@Component
public interface SampleService {
    Integer doAdd(String str1, String str2);
    int doSub(int num1, int num2);
    int doMul(int num1, int num2);
}
