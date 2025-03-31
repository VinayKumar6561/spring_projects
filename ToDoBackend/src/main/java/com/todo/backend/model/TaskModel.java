package com.todo.backend.model;

import java.time.LocalDate;

public class TaskModel {
    private int taskId;
    private String taskName;
    private String status;
    private LocalDate dueDate;
    private int userId;

    // Default constructor (needed for Spring)
    public TaskModel() {}

    // Constructor with parameters
    public TaskModel(int taskId, String taskName, String status, LocalDate dueDate, int userId) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    // Getters and Setters
    public int getTaskId() { return taskId; }
    public void setTaskId(int taskId) { this.taskId = taskId; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
