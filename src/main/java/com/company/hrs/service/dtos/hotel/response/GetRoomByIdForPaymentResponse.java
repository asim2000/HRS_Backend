package com.company.hrs.service.dtos.hotel.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRoomByIdForPaymentResponse {
    private Long id;
    private Float pricePerNight;
}
