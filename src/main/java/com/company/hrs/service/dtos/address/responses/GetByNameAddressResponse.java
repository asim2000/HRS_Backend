package com.company.hrs.service.dtos.address.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByNameAddressResponse {
    private String id;
    private GetAllAddressResponse parent;
    private String name;
}
