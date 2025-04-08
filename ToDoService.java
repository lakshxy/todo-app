package com.todo.service;

import com.todo.model.ToDo;
import com.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    // Create a new ToDo
    public ToDo createToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    // List all ToDos in descending order
    public List<ToDo> getAllToDos() {
        return toDoRepository.findAllByOrderByCreatedAtDesc();
    }

    // Mark a ToDo as completed
    public ToDo updateStatus(Long id) {
        ToDo todo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found"));
        todo.setStatus(ToDo.Status.COMPLETED);
        return toDoRepository.save(todo);
    }
}
