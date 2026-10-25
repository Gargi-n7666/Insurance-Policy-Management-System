package com.example.insurance.controller.admin;

import com.example.insurance.entity.PremiumPayment;
import com.example.insurance.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin/payments")
public class AdminPaymentController {
	private final PaymentService s;

	public AdminPaymentController(PaymentService s) {
		this.s = s;
	}

	@GetMapping
	public List<PremiumPayment> all() {
		return s.getAll();
	}

	@PutMapping("/{id}")
	public PremiumPayment update(@PathVariable Long id, @Valid @RequestBody PremiumPayment p) {
		return s.update(id, p);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		s.delete(id);
	}
}