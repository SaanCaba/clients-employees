package com.example.demo.services;

import com.example.demo.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);

    void deleteEmployeeById(Long parseLong);

    void createEmployee(Employee employee);
}
