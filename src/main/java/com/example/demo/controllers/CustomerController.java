package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;
import com.example.demo.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private ICustomerService service;

    @GetMapping("/api/customers/")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Customer> getAllCustomers(){
        return service.getAll();
    }

    @GetMapping("/api/customers/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Customer getCustomerById(@PathVariable String id){
        return service.getById(Long.parseLong(id));
    }

    @DeleteMapping("/api/customers/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public void deleteCustomerById(@PathVariable String id){
        service.deleteById(Long.parseLong(id));
    }

    @PostMapping("api/customers/")
    @CrossOrigin(origins = "http://localhost:3000")
    public void saveNewCustomer(@RequestBody Customer customer){
        service.saveCustomer(customer);
    }

}
