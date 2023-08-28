package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.AccountService;
import com.company.hrs.service.dtos.account.requests.LoginRequest;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @PostMapping("register")
    public Result register(@ModelAttribute()  RegisterRequest request){
        return accountService.register(request);
    }
    @PostMapping("login")
    public DataResult<String> login(@RequestBody LoginRequest request){
        return accountService.login(request);
    }
}