package com.example.insurance.controller.admin;

import com.example.insurance.entity.Policy;
import com.example.insurance.service.PolicyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/policies")
public class AdminPolicyController {
	private final PolicyService s;

	public AdminPolicyController(PolicyService s) {
		this.s = s;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Policy create(@RequestParam Long customerId, @Valid @RequestBody Policy p) {
		return s.create(p, customerId);
	}

	@GetMapping
	public List<Policy> all() {
		return s.getAll();
	}

	@GetMapping("/{id}")
	public Policy one(@PathVariable Long id) {
		return s.getById(id);
	}

	@PutMapping("/{id}")
	public Policy update(@PathVariable Long id, @Valid @RequestBody Policy p) {
		return s.update(id, p);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		s.delete(id);
	}
}