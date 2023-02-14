package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private CustomerRepository repository;
    @Override
    public List<Customer> getAll(){
        return (List<Customer>) repository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        //en un principio nos devuelve un optional, pero con el .get() traemos el Customer.
        return (Customer) repository.findById(id).get();
    }
    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }

    @Override
    public void saveCustomer(Customer customer){
        repository.save(customer);
    }

    ;
}
