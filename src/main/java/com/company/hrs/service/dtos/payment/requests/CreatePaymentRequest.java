package com.company.hrs.service.dtos.payment.requests;

import com.company.hrs.entities.Booking;
import com.company.hrs.entities.CreditCard;
import com.company.hrs.enums.PaymentStatus;
import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import com.company.hrs.service.dtos.creditCard.requests.CreateCreditCardRequest;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {
    @NotNull
    private CreateCreditCardRequest creditCard;
    @NotNull
    private CreateBookingRequest booking;
    @NotNull
    private Float amount;
    @NotNull
    private Boolean isSaveCard;
}
