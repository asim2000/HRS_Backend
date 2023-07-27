package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.PaymentService;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentRequest;
import com.company.hrs.service.result.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
@CrossOrigin
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping("create")
    public Result create(@RequestBody @Valid CreatePaymentRequest createPaymentRequest){
        return paymentService.create(createPaymentRequest);
    }
}
