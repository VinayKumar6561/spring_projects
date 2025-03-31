package com.todo.backend.controller;

import com.todo.backend.model.TaskModel;
import com.todo.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
//@CrossOrigin(origins = "http://localhost:5173") // Ensure frontend can access backend
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Fetch tasks by userId
    @GetMapping("/user/{userId}")
    public List<TaskModel> getTasksByUserId(@PathVariable int userId) {
        return taskService.getTasksByUserId(userId);
    }

    // Add a new task
    @PostMapping("/add")
    public String addTask(@RequestBody TaskModel task) {
        taskService.addTask(task);
        return "Task added successfully!";
    }

    // Update task status
    @PutMapping("/update/{taskId}")
    public String updateTask(@PathVariable int taskId, @RequestBody TaskModel updatedTask) {
        taskService.updateTask(taskId, updatedTask);
        return "Task updated successfully!";
    }


    // Delete task
    @DeleteMapping("/delete/{taskId}")
    public String deleteTask(@PathVariable int taskId) {
        taskService.deleteTask(taskId);
        return "Task deleted successfully!";
    }
}
