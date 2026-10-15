package com.example.insurance.service;

import java.util.List;
import com.example.insurance.entity.Claim;

public interface ClaimService {
    Claim create(Long policyId, Claim input);
    List<Claim> getAll();
    List<Claim> getByPolicyId(Long policyId);
    Claim update(Long id, Claim input);
    Claim updateStatus(Long id, String status);
    void delete(Long id);
}
