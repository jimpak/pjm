package com.pjm.app09_todo.repository;

import com.pjm.app09_todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
