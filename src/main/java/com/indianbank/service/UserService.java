package com.indianbank.service;

import com.indianbank.dto.BankResponse;
import com.indianbank.dto.UserDTO;

public interface UserService {
    public BankResponse createAccount(UserDTO userDTO);
}
