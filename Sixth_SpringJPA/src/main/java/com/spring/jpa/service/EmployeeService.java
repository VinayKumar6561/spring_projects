package com.spring.jpa.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.jpa.model.Employee;
import com.spring.jpa.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String getEmployeeDetails() {
        return "This is Employee Details Page";
    }

    public List<Employee> selectEmployee() {
        return employeeRepository.findAll();
    }

    public Employee selectEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployeeByRole(String role) {
        return employeeRepository.findByRole(role);
    }

    public String insertEmployee(Employee emp) {
        employeeRepository.save(emp);
        return "Employee Added Successfully!";
    }

    public String updateEmployee(Employee emp) {
        if (employeeRepository.existsById(emp.getId())) {
            employeeRepository.save(emp);
            return "Employee Updated Successfully!";
        }
        return "Employee Not Found!";
    }

    public String deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee Deleted Successfully!";
        }
        return "Employee Not Found!";
    }
}
