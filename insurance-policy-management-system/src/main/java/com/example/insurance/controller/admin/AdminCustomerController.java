package com.example.insurance.controller.admin;

import com.example.insurance.entity.*;
import com.example.insurance.service.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/customers")
public class AdminCustomerController {
	private final CustomerService s;
	private final LoginAccountService l;

	public AdminCustomerController(CustomerService s, LoginAccountService l) {
		this.s = s;
		this.l = l;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer create(@Valid @RequestBody Customer c) {
		return s.create(c);
	}

	@GetMapping
	public List<Customer> all() {
		return s.getAll();
	}

	@GetMapping("/{id}")
	public Customer one(@PathVariable Long id) {
		return s.getById(id);
	}

	@PutMapping("/{id}")
	public Customer update(@PathVariable Long id, @Valid @RequestBody Customer c) {
		return s.update(id, c);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		s.delete(id);
	}

	@PostMapping("/{id}/login-account")
	@ResponseStatus(HttpStatus.CREATED)
	public LoginAccount loginAccount(@PathVariable Long id, @Valid @RequestBody LoginAccount a) {
		return l.createForCustomer(id, a);
	}
}