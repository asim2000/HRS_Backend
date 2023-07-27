package com.company.hrs.service.dtos.payment.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentsByBookingResponse {
    private Long id;
    private Float amount;
}
