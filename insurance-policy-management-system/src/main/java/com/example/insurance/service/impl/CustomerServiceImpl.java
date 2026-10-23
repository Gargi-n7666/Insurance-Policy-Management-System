package com.example.insurance.service.impl;

import com.example.insurance.service.CustomerService;
import com.example.insurance.entity.Customer;
import com.example.insurance.repository.CustomerRepository;
import com.example.insurance.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
	private final CustomerRepository repo;

	public CustomerServiceImpl(CustomerRepository r) {
		repo = r;
	}

	public List<Customer> getAll() {
		return repo.findAll();
	}

	public Customer getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
	}

	public Customer create(Customer c) {
		c.setCustomerId(null);
		return repo.save(c);
	}

	public Customer update(Long id, Customer x) {
		Customer c = getById(id);
		c.setName(x.getName());
		c.setAddress(x.getAddress());
		c.setEmail(x.getEmail());
		c.setPhoneNumber(x.getPhoneNumber());
		c.setAge(x.getAge());
		c.setGender(x.getGender());
		return repo.save(c);
	}

	public void delete(Long id) {
		Customer c = getById(id);
		if (c.getPolicy() != null)
			throw new IllegalArgumentException("Delete related policy records first");
		repo.delete(c);
	}
}
