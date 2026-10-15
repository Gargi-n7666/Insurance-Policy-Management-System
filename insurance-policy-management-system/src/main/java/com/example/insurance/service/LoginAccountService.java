package com.example.insurance.service;

import java.util.Map;
import com.example.insurance.entity.LoginAccount;

public interface LoginAccountService {
    LoginAccount createForCustomer(Long customerId, LoginAccount input);
    Map<String, Object> login(String username, String password);
}
