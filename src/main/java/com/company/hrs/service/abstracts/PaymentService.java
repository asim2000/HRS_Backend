package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.payment.requests.CreatePaymentRequest;
import com.company.hrs.service.result.Result;

public interface PaymentService {
    Result create(CreatePaymentRequest createPaymentRequest);
}
