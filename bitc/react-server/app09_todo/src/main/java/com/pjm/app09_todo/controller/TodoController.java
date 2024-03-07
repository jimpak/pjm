package com.pjm.app09_todo.controller;

import com.pjm.app09_todo.model.Todo;
import com.pjm.app09_todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/insert")
    public Todo insert(@RequestBody Todo todo) {
        return todoService.insert(todo);
    }

    @GetMapping("/list")
    public List<Todo> list() {
        return todoService.list();
    }

    @DeleteMapping("/delete/{num}")
    public void delete(@PathVariable Long num) {
        todoService.delete(num);
    }
}
