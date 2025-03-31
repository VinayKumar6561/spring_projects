// EmployeeController.java
package com.spring.third.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.third.model.EmployeeModel;
import com.spring.third.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    // Endpoint to get basic employee details
    @GetMapping("/emp/details")
    public String getEmployeeDetails() {
        return empService.getEmployeeDetails();
    }

    // Endpoint to add two numbers using PathVariable
    @GetMapping("/emp/details/{id1}/{id2}")
    public int addNumbers(@PathVariable("id1") int a, @PathVariable("id2") int b) {
        return a + b;
    }

    // Endpoint to add two numbers using RequestParam
    @PostMapping("/emp/details")
    public int addNumbersWithPost(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // Endpoint to handle EmployeeModel data through RequestBody
    @PostMapping("/emp/pst")
    public String handleEmployeeData(@RequestBody EmployeeModel empmod) {
        return "Employee ID: " + empmod.getId();
    }

    // Insert a new employee
    @PostMapping("/emp/inserting")
    public String insertEmployee(@RequestBody EmployeeModel empmod) {
        return empService.insertEmployee(empmod);
    }

    // Update an existing employee
    @PostMapping("/emp/updating")
    public String updateEmployee(@RequestBody EmployeeModel empmod) {
        return empService.updateEmployee(empmod);
    }

    // Delete an employee
    @PostMapping("/emp/deleting")
    public String deleteEmployee(@RequestBody EmployeeModel empmod) {
        return empService.deleteEmployee(empmod);
    }

    // Get all employees
    @GetMapping("/emp/selecting")
    public List<EmployeeModel> selectEmployee() {
        return empService.selectEmployee();
    }

    // Get employee by ID
    @GetMapping("/emp/selectbyid/{id}")
    public List<EmployeeModel> getEmployeeById(@PathVariable int id) {
        return empService.selectEmployeeById(id);
    }

    // Get employee by role
    @GetMapping("/emp/selectbyrole")
    public List<EmployeeModel> getEmployeeByRole(@RequestParam String role) {
        return empService.getEmployeeByRole(role);
    }
}
