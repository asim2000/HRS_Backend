package com.company.hrs.service.dtos.hotel.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetHotelReportResponse {
    Integer reserveCount;
    Float totalProfit;
    Float netProfit;
}
