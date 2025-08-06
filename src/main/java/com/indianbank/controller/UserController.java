package com.indianbank.controller;

import com.indianbank.dto.*;
import com.indianbank.service.UserService;
import com.indianbank.utils.AccountUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Tag(name = "User Account Management REST API's")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Create New User Account",
            description = "Creating a new user and assigning an account ID"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<BankResponse> createAccount(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createAccount(userDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Balance Enquiry",
            description = "User can give account number and check available balance"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping("/balanceEnquiry")
    public ResponseEntity<BankResponse> balanceEnquiry(@RequestBody EnquiryRequest request) {
        BankResponse response = userService.balanceEnquiry(request);
        if(response.getAccountInfo() == null)
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Operation(
            summary = "Name Enquiry",
            description = "User can give account number and check name linked with account correct or not"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
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

    @PostMapping("/transfer")
    public ResponseEntity<BankResponse> transfer(@RequestBody TransferRequest transferRequest) {
        BankResponse response = userService.transfer(transferRequest);
        if((response.getAccountInfo() == null && response.getResponseMessage().equals(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE)) || response.getAccountInfo() == null && response.getResponseMessage().equals(AccountUtils.INSUFFICIENT_BALANCE_MESSAGE))
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
