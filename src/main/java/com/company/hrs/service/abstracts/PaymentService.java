package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.payment.requests.CreatePaymentForBrokerRequest;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForCustomerRequest;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForHotelRequest;
import com.company.hrs.service.result.Result;

public interface PaymentService {
    Result createPaymentForCustomer(CreatePaymentForCustomerRequest createPaymentForCustomerRequest);
    Result createPaymentForHotel(CreatePaymentForHotelRequest createPaymentForHotelRequest);

    Result createPaymentForBroker(CreatePaymentForBrokerRequest createPaymentForBrokerRequest);
}
