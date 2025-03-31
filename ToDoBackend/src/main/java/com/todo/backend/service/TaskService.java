package com.todo.backend.service;

import com.todo.backend.model.TaskModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<TaskModel> getTasksByUserId(int userId) {
        String sql = "SELECT * FROM tasks WHERE user_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new TaskModel(
            rs.getInt("task_id"),
            rs.getString("task_name"),
            rs.getString("status"),
            rs.getDate("due_date").toLocalDate(),
            rs.getInt("user_id")
        ), userId);
    }


//    public List<TaskModel> getTasksByUserId(int userId) {
//        String sql = "SELECT * FROM tasks WHERE user_id = ?";
//        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> 
//            new TaskModel(
//                rs.getInt("task_id"),
//                rs.getString("task_name"),
//                rs.getString("status"),
//                rs.getDate("due_date").toLocalDate(),
//                rs.getInt("user_id")
//            )
//        );
//    }

    public void addTask(TaskModel task) {
        String sql = "INSERT INTO tasks (task_name, status, due_date, user_id) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, task.getTaskName(), task.getStatus(), task.getDueDate(), task.getUserId());
    }

    public void updateTask(int taskId, TaskModel updatedTask) {
        String sql = "UPDATE tasks SET task_name = ?, status = ?, due_date = ? WHERE task_id = ?";
        jdbcTemplate.update(sql, updatedTask.getTaskName(), updatedTask.getStatus(), updatedTask.getDueDate(), taskId);
    }


    public void deleteTask(int taskId) {
        String sql = "DELETE FROM tasks WHERE task_id = ?";
        jdbcTemplate.update(sql, taskId);
    }
}
