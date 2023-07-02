package com.company.hrs.service.dtos.address.requestes;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {
    @NotBlank
    @NotNull
    private String id;
    @Column(name = "CITY_ID")
    private String cityId;
    @NotBlank
    @NotNull
    private String addressLine;
}
