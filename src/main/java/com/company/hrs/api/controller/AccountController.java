package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.AccountService;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService;

    @PostMapping("register")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void registerForCustomer(@Valid @RequestBody RegisterRequest request){
        accountService.register(request);
    }
}
