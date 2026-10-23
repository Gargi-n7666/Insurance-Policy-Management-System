package com.example.insurance.controller.admin;

import com.example.insurance.entity.Claim;
import com.example.insurance.service.ClaimService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/claims")
public class AdminClaimController {
	private final ClaimService s;

	public AdminClaimController(ClaimService s) {
		this.s = s;
	}

	@GetMapping
	public List<Claim> all() {
		return s.getAll();
	}

	@PutMapping("/{id}/status")
	public Claim status(@PathVariable Long id, @RequestBody Map<String, String> b) {
		return s.updateStatus(id, b.getOrDefault("claimStatus", "PENDING"));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		s.delete(id);
	}
}