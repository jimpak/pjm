package org.pjm.springexam03.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/todo")
public class TodoController {

    @PostMapping("/write")
    public String write(String name, String age, Model model) {
        log.info(name);
        log.info(age);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "todo/view";
    }

    @GetMapping("/write")
    public void writeform() {

    }

    @GetMapping("/ex01")
    public String ex01(){
        log.info("ex01");
        return "todo/ex01";
    }

    @GetMapping("hello")
    public void hello() {
        log.info("Hello");
    }
}
