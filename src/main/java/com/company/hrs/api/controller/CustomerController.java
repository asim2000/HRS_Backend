package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @PostMapping()
    public void create(){

    }
}
