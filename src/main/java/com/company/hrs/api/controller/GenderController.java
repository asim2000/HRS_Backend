package com.company.hrs.api.controller;

import com.company.hrs.enums.Gender;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
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
    public DataResult<List<Gender>> getAll(){
        return new SuccessDataResult<List<Gender>>(Arrays.stream(Gender.values()).toList());
    }
}
