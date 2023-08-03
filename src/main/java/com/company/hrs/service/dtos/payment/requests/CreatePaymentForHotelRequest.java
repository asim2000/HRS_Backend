package com.company.hrs.service.dtos.payment.requests;

import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentForHotelRequest {
    @NotNull
    private CreateBookingRequest booking;
    @NotNull
    private Float amount;
}
