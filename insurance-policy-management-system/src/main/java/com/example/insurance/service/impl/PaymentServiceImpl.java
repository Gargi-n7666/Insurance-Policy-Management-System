package com.example.insurance.service.impl;

import com.example.insurance.service.PaymentService;
import com.example.insurance.entity.*;
import com.example.insurance.repository.*;
import com.example.insurance.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.*;

@Service
public class PaymentServiceImpl implements PaymentService {
	private final PremiumPaymentRepository repo;
	private final PolicyRepository policies;

	public PaymentServiceImpl(PremiumPaymentRepository r, PolicyRepository p) {
		repo = r;
		policies = p;
	}

	public List<PremiumPayment> getAll() {
		return repo.findAll();
	}

	public PremiumPayment getById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found: " + id));
	}

	public List<PremiumPayment> getByPolicyId(Long id) {
		if (!policies.existsById(id))
			throw new ResourceNotFoundException("Policy not found: " + id);
		return repo.findByPolicyPolicyId(id);
	}

	public PremiumPayment create(Long policyId, PremiumPayment p) {
		Policy policy = policies.findById(policyId)
				.orElseThrow(() -> new ResourceNotFoundException("Policy not found: " + policyId));
		p.setPaymentId(null);
		p.setPolicy(policy);
		return repo.save(p);
	}

	public PremiumPayment update(Long id, PremiumPayment p) {
		PremiumPayment old = getById(id);
		old.setAmount(p.getAmount());
		old.setPaymentDate(p.getPaymentDate());
		old.setPaymentMode(p.getPaymentMode());
		old.setTransactionId(p.getTransactionId());
		old.setPaymentStatus(p.getPaymentStatus());
		return repo.save(old);
	}

	public void delete(Long id) {
		repo.delete(getById(id));
	}
}
