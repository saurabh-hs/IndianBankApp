package com.indianbank.controller;

import com.indianbank.dto.BankResponse;
import com.indianbank.dto.UserDTO;
import com.indianbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<BankResponse> createAccount(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createAccount(userDTO), HttpStatus.CREATED);
    }
}
