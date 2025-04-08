package com.example.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @PostMapping
    public ToDo createToDo(@RequestBody ToDo todo) {
        return toDoRepository.save(todo);
    }

    @GetMapping
    public List<ToDo> getAllToDos() {
        return toDoRepository.findAllByOrderByCreatedAtDesc();
    }

    @PutMapping("/{id}/complete")
    public ToDo markAsComplete(@PathVariable Long id) {
        ToDo todo = toDoRepository.findById(id).orElseThrow();
        todo.setCompleted(true);
        return toDoRepository.save(todo);
    }
}
