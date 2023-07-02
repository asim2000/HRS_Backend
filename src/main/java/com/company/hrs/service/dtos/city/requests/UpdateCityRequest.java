package com.company.hrs.service.dtos.city.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCityRequest {
    private String id;
    private String name;
}
