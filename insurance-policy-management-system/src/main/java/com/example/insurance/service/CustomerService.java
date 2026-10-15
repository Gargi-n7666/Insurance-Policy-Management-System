package com.example.insurance.service;

import java.util.List;
import com.example.insurance.entity.Customer;

public interface CustomerService {
    Customer create(Customer input);
    List<Customer> getAll();
    Customer getById(Long id);
    Customer update(Long id, Customer input);
    void delete(Long id);
}
