package com.example.restex.controller;

import com.example.restex.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@Log4j2
@RestController // 해당 이노테이션을 붙이면 객체마다 ResponseBody를 붙일 필요가 없어진다.
public class SampleController {
    // rest는 리턴값을 뷰로 보냄.
    @GetMapping("/test1")
//    @ResponseBody
    public String test1() {
        return "Hello";
    }

    @GetMapping("/test2")
//    @ResponseBody
    public SampleDTO test2() {
        return new SampleDTO("홍길동", 20, "남자");
    }

    @GetMapping("/test3")
//    @ResponseBody
    public List<SampleDTO> test3() {
        List<SampleDTO> dtoList = new ArrayList<SampleDTO>();
        for(int i = 1; i < 5; i++) {
            String gender = i % 2 == 0 ? "여자" : "남자";
            dtoList.add(new SampleDTO("test"+i, 20+i, gender));
        }
        return dtoList;
    }

    @GetMapping("/test4")
    public Map<String, SampleDTO> test4() {
        Map<String, SampleDTO> maps = new HashMap<>();
        maps.put("dto1", new SampleDTO("hong", 25, "M"));
        maps.put("dto2", new SampleDTO("kim", 21, "F"));
        return maps;
    }

    @GetMapping("/test5")
    public Map<String, List<SampleDTO>> test5() {
        List<SampleDTO> dtoList = new ArrayList<SampleDTO>();
        for(int i = 1; i < 5; i++) {
            String gender = i % 2 == 0 ? "여자" : "남자";
            dtoList.add(new SampleDTO("test"+i, 20+i, gender));
        }
        Map<String, List<SampleDTO>> map = new HashMap<>();
        map.put("dtoList", dtoList);
        return map;
    }

    // 주로 ResponseEntity 타입을 이용하는 것이 일반적
    @GetMapping(value = "/test6", params = {"name", "age"})
    public ResponseEntity<SampleDTO> test6(String name, int age) {
        SampleDTO dto = new SampleDTO(name, age, "F");
        ResponseEntity<SampleDTO> result = null;
        if(age >= 20) {
            result = ResponseEntity.status(HttpStatus.OK).body(dto);
        } else {
            result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
        }
        return result;
    }

    // @PathVariable : URL 경로의 일부를 파라미터로 사용할 때 이용
    // http://localhost:8082/test7/bags/1234
    @GetMapping("/test7/{cat}/{pid}")
    public String[] getPath(@PathVariable("cat") String cat,
                            @PathVariable("pid") int pid) {
        return new String[] {"category:" + cat, "productid:" + pid};
    }

    @PostMapping("/test8")
    public SampleDTO test8(@RequestBody SampleDTO dto) {
        log.info(dto);
        return dto;
    }

}
