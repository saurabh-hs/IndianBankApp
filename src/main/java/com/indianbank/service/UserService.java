package com.indianbank.service;

import com.indianbank.dto.*;

public interface UserService {
    public BankResponse createAccount(UserDTO userDTO);

    public BankResponse balanceEnquiry(EnquiryRequest request);

    public String nameEnquiry(EnquiryRequest request);

    public BankResponse creditAccount(CreditDebitRequest creditDebitRequest);

    public BankResponse debitAccount(CreditDebitRequest creditDebitRequest);

    public BankResponse transfer(TransferRequest transferRequest);

    public BankResponse login(LoginDTO loginDTO);
}
