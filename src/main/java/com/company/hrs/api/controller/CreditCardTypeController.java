package com.company.hrs.api.controller;

import com.company.hrs.enums.CreditCardType;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("creditcardtype")
@CrossOrigin
public class CreditCardTypeController {
    @GetMapping("getall")
    public DataResult<List<CreditCardType>> getAll(){
        return new SuccessDataResult<>(Arrays.stream(CreditCardType.values()).toList());
    }
}
