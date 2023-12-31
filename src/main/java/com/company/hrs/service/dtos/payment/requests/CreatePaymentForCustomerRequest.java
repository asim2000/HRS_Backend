package com.company.hrs.service.dtos.payment.requests;

import com.company.hrs.service.dtos.booking.requests.CreateBookingForCustomerRequest;
import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import com.company.hrs.service.dtos.creditCard.requests.CreateCreditCardRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentForCustomerRequest {
    @NotNull
    private CreateCreditCardRequest creditCard;
    @NotNull
    private CreateBookingForCustomerRequest booking;
    @NotNull
    private Float amount;
    @NotNull
    private Boolean isSaveCard;
}
