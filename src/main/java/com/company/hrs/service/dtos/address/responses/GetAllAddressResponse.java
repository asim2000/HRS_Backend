package com.company.hrs.service.dtos.address.responses;

import com.company.hrs.entities.Address;
import com.company.hrs.service.dtos.city.responses.GetAllCityResponse;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllAddressResponse {
    private String id;
    private GetAllCityResponse city;
    @Column(name = "ADDRESS_LINE")
    private String addressLine;

}
