package com.company.hrs.service.dtos.city.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCityResponse {
    private Long id;
    private String name;
}
