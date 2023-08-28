package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.PaymentService;
import com.company.hrs.service.dtos.payment.requests.AddPaymentByHotelRequest;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForBrokerRequest;
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
    @PostMapping("CreateForCustomer")
    public Result createPaymentForCustomer(@RequestBody @Valid CreatePaymentForCustomerRequest createPaymentRequest){
        return paymentService.createPaymentForCustomer(createPaymentRequest);
    }
    @PostMapping("CreateForHotel")
    public Result createPaymentForHotel(@RequestBody @Valid CreatePaymentForHotelRequest createPaymentForHotelRequest){
        return paymentService.createPaymentForHotel(createPaymentForHotelRequest);
    }
    @PostMapping("CreateForBroker")
    public Result createPaymentForBroker(@RequestBody @Valid CreatePaymentForBrokerRequest createPaymentForBrokerRequest){
        return paymentService.createPaymentForBroker(createPaymentForBrokerRequest);
    }
    @PostMapping("add/hotel")
    public Result addPaymentByHotel(@RequestBody @Valid AddPaymentByHotelRequest request){
        return paymentService.addPaymentByHotel(request);
    }
}
