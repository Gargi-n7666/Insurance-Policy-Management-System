package com.example.insurance.service.impl;

import com.example.insurance.service.PolicyService;
import com.example.insurance.entity.*; import com.example.insurance.repository.*; import com.example.insurance.exception.ResourceNotFoundException; import org.springframework.stereotype.Service;
import java.util.List; import java.util.*;
@Service public class PolicyServiceImpl implements PolicyService { private final PolicyRepository repo; private final CustomerRepository customers; public PolicyServiceImpl(PolicyRepository r,CustomerRepository c){repo=r;customers=c;}
    @Override
public List<Policy> getAll(){return repo.findAll();} public Policy getById(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Policy not found: "+id));}
    @Override
public Policy create(Policy p,Long customerId){if(repo.existsByPolicyNumber(p.getPolicyNumber()))throw new IllegalArgumentException("Policy number already exists"); Customer c=customers.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer not found: "+customerId)); if(c.getPolicy()!=null)throw new IllegalArgumentException("Customer already has a policy in this one-to-one model"); if(p.getEndDate().isBefore(p.getStartDate()))throw new IllegalArgumentException("End date must not be before start date"); p.setPolicyId(null);p.setCustomer(c);return repo.save(p);}
    @Override
public Policy update(Long id,Policy p){Policy old=getById(id);p.setPolicyId(id);p.setCustomer(old.getCustomer());return repo.save(p);} public void delete(Long id){Policy p=getById(id);if(!p.getPayments().isEmpty()||!p.getClaims().isEmpty())throw new IllegalArgumentException("Delete related payments and claims first");repo.delete(p);} public Policy getByCustomerId(Long id){return repo.findAll().stream().filter(p->p.getCustomer().getCustomerId().equals(id)).findFirst().orElseThrow(()->new ResourceNotFoundException("Policy not found for customer: "+id));} }
