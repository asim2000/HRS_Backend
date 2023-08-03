package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.PaymentService;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForCustomerRequest;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForHotelRequest;
import com.company.hrs.service.result.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping("createpaymentforcustomer")
    public Result createPaymentForCustomer(@RequestBody @Valid CreatePaymentForCustomerRequest createPaymentRequest){
        return paymentService.createPaymentForCustomer(createPaymentRequest);
    }
    @PostMapping("createpaymentforhotel")
    public Result createpaymentforhotel(@RequestBody @Valid CreatePaymentForHotelRequest createPaymentForHotelRequest){
        return paymentService.createPaymentForHotel(createPaymentForHotelRequest);
    }
}
