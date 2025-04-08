package com.example.todo;

import com.todo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllByOrderByCreatedAtDesc();
}
