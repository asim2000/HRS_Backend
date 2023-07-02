package com.company.hrs.service.dtos.city.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedCityResponse {
    private String id;
    private String name;
}