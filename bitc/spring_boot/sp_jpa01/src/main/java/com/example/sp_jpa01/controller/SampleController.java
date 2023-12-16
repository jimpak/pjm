package com.example.sp_jpa01.controller;

import com.example.sp_jpa01.dto.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Log4j2
@Controller
public class SampleController {
    @GetMapping("/hello")
    public void hello(Model model) {
        log.info("hello........................");
        model.addAttribute("msg", "Hello world");
    }

    @GetMapping("/json")
    @ResponseBody
    public String[] json() {
        return new String[]{"AA", "BB", "CC"};
    }

    @GetMapping("/dto")
    @ResponseBody
    public SampleDTO dto() {
        return new SampleDTO("홍길동", 20);
    }

//    @GetMapping("/ex01")
//    @ResponseBody
//    public void dto(Model model) {
//        model.addAttribute("list", new SampleDTO("홍길동", 20));
//    }

    @GetMapping("/ex01")
    public void ex01(Model model) {
        List<String> list = Arrays.asList("AA", "BB", "CC");
        model.addAttribute("list", list);
    }

    @GetMapping("/dtoList")
    @ResponseBody
    public List<SampleDTO> dtoList() {
        List<SampleDTO> dtoList = new ArrayList<>();
        dtoList.add(new SampleDTO("홍길동", 20));
        dtoList.add(new SampleDTO("강감찬", 25));
        dtoList.add(new SampleDTO("이방원", 22));
        return dtoList;
    }

    @GetMapping("/dtoList2")
    public void dtoList2(Model model) {
        List<SampleDTO> dtoList = new ArrayList<>();
        dtoList.add(new SampleDTO("홍길동", 20));
        dtoList.add(new SampleDTO("강감찬", 25));
        dtoList.add(new SampleDTO("이방원", 22));
        model.addAttribute("dtoList", dtoList);
    }

    @GetMapping("/script")
    public void stript(Model model) {
        List<SampleDTO> dtoList = new ArrayList<>();
        dtoList.add(new SampleDTO("홍길동", 20));
        dtoList.add(new SampleDTO("강감찬", 25));
        dtoList.add(new SampleDTO("이방원", 22));
        model.addAttribute("list", dtoList);

        Map<String, SampleDTO> map = new HashMap<>();
        map.put("dto", new SampleDTO("박정민", 33));
        model.addAttribute("map", map);

        SampleDTO dto = new SampleDTO("유재석", 48);
        model.addAttribute("dto", dto);
    }

    @GetMapping("/ex02")
    public void ex02() {

    }
}

