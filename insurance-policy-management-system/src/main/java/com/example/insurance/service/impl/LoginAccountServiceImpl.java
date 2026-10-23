package com.example.insurance.service.impl;

import com.example.insurance.service.LoginAccountService;
import com.example.insurance.entity.*;
import com.example.insurance.repository.*;
import com.example.insurance.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.*;

@Service
public class LoginAccountServiceImpl implements LoginAccountService {
	private final LoginAccountRepository repo;
	private final CustomerRepository customers;

	public LoginAccountServiceImpl(LoginAccountRepository r, CustomerRepository c) {
		repo = r;
		customers = c;
	}

	public LoginAccount createForCustomer(Long id, LoginAccount a) {
		Customer c = customers.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found: " + id));
		if (repo.existsByUsername(a.getUsername()))
			throw new IllegalArgumentException("Username already exists");
		a.setLoginAccountId(null);
		a.setCustomer(c);
		a.setRole("CUSTOMER");
		a.setActive(true);
		return repo.save(a);
	}

	public Map<String, Object> login(String u, String p) {
		LoginAccount a = repo.findByUsernameAndPasswordAndActiveTrue(u, p)
				.orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
		Map<String, Object> m = new LinkedHashMap<>();
		m.put("message", "Login successful");
		m.put("username", a.getUsername());
		m.put("role", a.getRole());
		m.put("customerId", a.getCustomer() == null ? null : a.getCustomer().getCustomerId());
		return m;
	}
}
