package com.pjm.app09_todo.service;

import com.pjm.app09_todo.model.Todo;
import com.pjm.app09_todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo insert(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> list() {
        return todoRepository.findAll();
    }

    public void delete(Long num) {
        todoRepository.deleteById(num);
    }
}
