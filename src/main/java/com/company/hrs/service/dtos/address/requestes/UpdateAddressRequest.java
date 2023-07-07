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
    private Long id;
    @Column(name = "city_id")
    private Long cityId;
    @NotBlank
    @NotNull
    @Column(name = "address_line")
    private String addressLine;
}
