package com.company.hrs.service.dtos.payment.requests;

import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePaymentForBrokerRequest {
    @NotNull
    CreateBookingRequest booking;
    @NotNull
    Float amount;
}
