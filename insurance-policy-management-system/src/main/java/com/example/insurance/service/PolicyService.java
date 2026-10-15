package com.example.insurance.service;

import java.util.List;
import com.example.insurance.entity.Policy;

public interface PolicyService {
    Policy create(Policy input, Long customerId);
    List<Policy> getAll();
    Policy getById(Long id);
    Policy getByCustomerId(Long customerId);
    Policy update(Long id, Policy input);
    void delete(Long id);
}
