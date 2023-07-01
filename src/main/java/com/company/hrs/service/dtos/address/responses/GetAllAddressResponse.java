package com.company.hrs.service.dtos.address.responses;

import com.company.hrs.entities.Address;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllAddressResponse {
    private String id;
    private GetAllAddressResponse parent;
    private String name;

}
