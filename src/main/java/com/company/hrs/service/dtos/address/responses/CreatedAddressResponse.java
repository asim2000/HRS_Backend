package com.company.hrs.service.dtos.address.responses;

import com.company.hrs.service.dtos.city.responses.GetAllCityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedAddressResponse {
    private String id;
    private GetAllCityResponse city;
    private String addressLine;
}