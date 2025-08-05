package com.indianbank.service;

import com.indianbank.dto.BankResponse;
import com.indianbank.dto.CreditDebitRequest;
import com.indianbank.dto.EnquiryRequest;
import com.indianbank.dto.UserDTO;

public interface UserService {
    public BankResponse createAccount(UserDTO userDTO);

    public BankResponse balanceEnquiry(EnquiryRequest request);

    public String nameEnquiry(EnquiryRequest request);

    public BankResponse creditAccount(CreditDebitRequest creditDebitRequest);

    public BankResponse debitAccount(CreditDebitRequest creditDebitRequest);
}
