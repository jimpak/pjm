package com.pjm.projectsns.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping("post/write")
    public String postWriteForm() {
        return "write";
    }

}
