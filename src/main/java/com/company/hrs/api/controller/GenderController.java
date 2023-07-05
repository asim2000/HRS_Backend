package com.company.hrs.api.controller;

import com.company.hrs.enums.Gender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("gender")
@CrossOrigin
public class GenderController {
    @GetMapping
    public List<Gender> getAll(){
        return Arrays.stream(Gender.values()).toList();
    }
}
