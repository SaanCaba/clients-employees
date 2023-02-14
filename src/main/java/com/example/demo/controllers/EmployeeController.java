package com.example.demo.controllers;

import com.example.demo.entities.Employee;
import com.example.demo.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService service;

    @GetMapping("/api/employees")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getAllEmployee(){
        try{
            List<Employee> employees = service.getAllEmployees();
            return new ResponseEntity<>(employees, HttpStatus.OK);
        }
        catch (DataAccessException e){
            Map<String, Object> response = new HashMap<>();
            response.put("ERROR", e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/api/employees/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Employee getEmployeeById(@PathVariable String id){
        return service.getEmployeeById(Long.parseLong(id));
    }
    @DeleteMapping("/api/employees/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteEmployeeById(@PathVariable String id){
        service.deleteEmployeeById(Long.parseLong(id));
    }

    @PostMapping("/api/employees")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
        Map<String, Object> response = new HashMap<>();
        try {
            service.createEmployee(employee);
            response.put("message: ", "The employee was created succesfully" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        }catch (DataAccessException e){
            response.put("Message: ", "An error ocurred to create one employee");
            response.put("ERROR", e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
