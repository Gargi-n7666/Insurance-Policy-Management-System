package com.example.insurance.service;

import java.util.List;
import com.example.insurance.entity.PremiumPayment;

public interface PaymentService {
    PremiumPayment create(Long policyId, PremiumPayment input);
    List<PremiumPayment> getAll();
    List<PremiumPayment> getByPolicyId(Long policyId);
    PremiumPayment update(Long id, PremiumPayment input);
    void delete(Long id);
}
