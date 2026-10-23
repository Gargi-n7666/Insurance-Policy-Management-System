package com.example.insurance.controller.user;

import com.example.insurance.entity.PremiumPayment;
import com.example.insurance.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/customer/policies")
public class CustomerPaymentController {
	private final PaymentService s;

	public CustomerPaymentController(PaymentService s) {
		this.s = s;
	}

	@PostMapping("/{id}/payments")
	@ResponseStatus(HttpStatus.CREATED)
	public PremiumPayment create(@PathVariable Long id, @Valid @RequestBody PremiumPayment p) {
		return s.create(id, p);
	}

	@GetMapping("/{id}/payments")
	public List<PremiumPayment> all(@PathVariable Long id) {
		return s.getByPolicyId(id);
	}
}