package com.company.hrs.service.dtos.address.requestes;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    @Column(name = "city_id")
    private Long cityId;
    @NotBlank
    @NotNull
    @Column(name = "address_line")
    private String addressLine;
}
