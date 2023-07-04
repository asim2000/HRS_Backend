package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.AccountService;
import com.company.hrs.service.dtos.account.requests.LoginRequest;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@AllArgsConstructor
@CrossOrigin
public class AccountController {
    private AccountService accountService;

    @PostMapping("register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void registerForCustomer(@RequestBody @Valid RegisterRequest request){
        accountService.register(request);
    }
    @PostMapping("login")
    public LoginPersonResponse login(@RequestBody @Valid LoginRequest request){
        return accountService.login(request);
    }
}
