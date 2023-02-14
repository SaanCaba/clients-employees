package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService service;

    @GetMapping("/api/employees")
    public List<Employee> getAllEmployee(){
        return service.getAllEmployees();
    }
    @GetMapping("/api/employees/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return service.getEmployeeById(Long.parseLong(id));
    }
    @DeleteMapping("/api/employees/{id}")
    public void deleteEmployeeById(@PathVariable String id){
        service.deleteEmployeeById(Long.parseLong(id));
    }

    @PostMapping("/api/employees")
    public void createEmployee(@RequestBody Employee employee){
        service.createEmployee(employee);
    }

}
