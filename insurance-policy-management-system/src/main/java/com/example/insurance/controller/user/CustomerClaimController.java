package com.example.insurance.controller.user;

import com.example.insurance.entity.Claim;
import com.example.insurance.service.ClaimService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerClaimController {
	private final ClaimService s;

	public CustomerClaimController(ClaimService s) {
		this.s = s;
	}

	@PostMapping("/policies/{id}/claims")
	@ResponseStatus(HttpStatus.CREATED)
	public Claim create(@PathVariable Long id, @Valid @RequestBody Claim c) {
		return s.create(id, c);
	}

	@GetMapping("/policies/{id}/claims")
	public List<Claim> all(@PathVariable Long id) {
		return s.getByPolicyId(id);
	}

	@PutMapping("/claims/{id}")
	public Claim update(@PathVariable Long id, @Valid @RequestBody Claim c) {
		return s.update(id, c);
	}
}