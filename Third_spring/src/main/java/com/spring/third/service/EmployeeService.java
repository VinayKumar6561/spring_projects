

// EmployeeService.java
package com.spring.third.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.spring.third.model.EmployeeModel;

@Service
public class EmployeeService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Basic endpoint to return employee details
    public String getEmployeeDetails() {
        return "This is Employee Details Page";
    }

    // Select all employees
    public List<EmployeeModel> selectEmployee() {
        String sql = "SELECT * FROM EMPLOYEE";
        return jdbcTemplate.query(sql, (rs, row) -> new EmployeeModel(
            rs.getInt("id"),
            rs.getString("ename"),
            rs.getString("role")
        ));
    }

    // Select employee by ID using queryForList
    public List<EmployeeModel> selectEmployeeById(int id) {
        String sql = "SELECT * FROM EMPLOYEE WHERE id = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, id);

        List<EmployeeModel> employeeList = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            EmployeeModel emp = new EmployeeModel(
                (int) row.get("id"),
                (String) row.get("ename"),
                (String) row.get("role")
            );
            employeeList.add(emp);
        }
        return employeeList;
    }

    // Select employee by role
    public List<EmployeeModel> getEmployeeByRole(String role) {
        String sql = "SELECT * FROM EMPLOYEE WHERE role = ?";
        return jdbcTemplate.query(sql, (rs, row) -> new EmployeeModel(
            rs.getInt("id"),
            rs.getString("ename"),
            rs.getString("role")
        ), role);
    }

    // Insert a new employee
    public String insertEmployee(EmployeeModel empmod) {
        String sql = "INSERT INTO EMPLOYEE (id, ename, role) VALUES (?, ?, ?)";
        int result = jdbcTemplate.update(sql, empmod.getId(), empmod.getEname(), empmod.getRole());
        return result > 0 ? "Employee Added Successfully!" : "Failed to Add Employee";
    }

    // Update an employee's name by ID
    public String updateEmployee(EmployeeModel empmod) {
        String sql = "UPDATE EMPLOYEE SET ename = ? WHERE id = ?";
        int result = jdbcTemplate.update(sql, empmod.getEname(), empmod.getId());
        return result > 0 ? "Employee Updated Successfully!" : "Failed to Update Employee";
    }

    // Delete an employee by ID
    public String deleteEmployee(EmployeeModel empmod) {
        String sql = "DELETE FROM EMPLOYEE WHERE id = ?";
        int result = jdbcTemplate.update(sql, empmod.getId());
        return result > 0 ? "Employee Deleted Successfully!" : "Failed to Delete Employee";
    }
}
