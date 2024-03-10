package com.pjm.projectsns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {

    @GetMapping("/home")
    public void postList() {

    }

    @GetMapping("/write")
    public String postWriteForm() {
        return "/post/write";
    }

}
