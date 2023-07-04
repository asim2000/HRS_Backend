package com.company.hrs.service.dtos.address.responses;

import com.company.hrs.service.dtos.city.responses.GetAllCityResponse;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByNameAddressResponse {
    private String id;
    private GetAllCityResponse parent;
    @Column(name = "ADDRESS_LINE")
    private String addressLine;
}
