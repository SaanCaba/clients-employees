package com.example.demo.services;

import com.example.demo.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    Customer getById(Long id);

    void deleteById(Long id);

    void saveCustomer(Customer customer);
}
