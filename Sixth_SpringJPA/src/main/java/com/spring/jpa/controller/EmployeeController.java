package com.spring.jpa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.jpa.model.Employee;
import com.spring.jpa.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/details")
    public String getEmployeeDetails() {
        return empService.getEmployeeDetails();
    }

    @GetMapping("/selecting")
    public List<Employee> selectEmployee() {
        return empService.selectEmployee();
    }

    @GetMapping("/selectbyid/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return empService.selectEmployeeById(id);
    }

    @GetMapping("/selectbyrole")
    public List<Employee> getEmployeeByRole(@RequestParam String role) {
        return empService.getEmployeeByRole(role);
    }

    @PostMapping("/inserting")
    public String insertEmployee(@RequestBody Employee emp) {
        return empService.insertEmployee(emp);
    }

    @PutMapping("/updating")
    public String updateEmployee(@RequestBody Employee emp) {
        return empService.updateEmployee(emp);
    }

    @DeleteMapping("/deleting/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return empService.deleteEmployee(id);
    }
}
