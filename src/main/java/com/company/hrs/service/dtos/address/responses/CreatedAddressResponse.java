package com.company.hrs.service.dtos.address.responses;

import com.company.hrs.service.dtos.city.responses.GetAllCityResponse;
import com.company.hrs.service.dtos.city.responses.GetCityResponse;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedAddressResponse {
    private Long id;
    private GetCityResponse city;
    @Column(name = "address_line")
    private String addressLine;
}
