package com.company.hrs.service.dtos.payment.requests;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddPaymentByHotelRequest {
    @Column(name="booking_id")
    Long bookingId;
    Float amount;
}
