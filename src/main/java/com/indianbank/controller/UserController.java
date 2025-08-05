package com.indianbank.controller;

import com.indianbank.dto.BankResponse;
import com.indianbank.dto.CreditDebitRequest;
import com.indianbank.dto.EnquiryRequest;
import com.indianbank.dto.UserDTO;
import com.indianbank.service.UserService;
import com.indianbank.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<BankResponse> createAccount(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createAccount(userDTO), HttpStatus.CREATED);
    }

    @GetMapping("/balanceEnquiry")
    public ResponseEntity<BankResponse> balanceEnquiry(@RequestBody EnquiryRequest request) {
        BankResponse response = userService.balanceEnquiry(request);
        if(response.getAccountInfo() == null)
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/nameEnquiry")
    public ResponseEntity<String> nameEnquiry(@RequestBody EnquiryRequest request) {
        String response = userService.nameEnquiry(request);
        if(response.equals(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE))
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/credit")
    public ResponseEntity<BankResponse> creditAccount(@RequestBody CreditDebitRequest creditDebitRequest) {
        BankResponse response = userService.creditAccount(creditDebitRequest);
        if(response.getAccountInfo() == null)
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/debit")
    public ResponseEntity<BankResponse> debitAccount(@RequestBody CreditDebitRequest creditDebitRequest) {
        BankResponse response = userService.debitAccount(creditDebitRequest);
        if(response.getAccountInfo() == null && response.getResponseMessage().equals(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE))
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        if(response.getAccountInfo() == null && response.getResponseMessage().equals(AccountUtils.INSUFFICIENT_BALANCE_MESSAGE))
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
