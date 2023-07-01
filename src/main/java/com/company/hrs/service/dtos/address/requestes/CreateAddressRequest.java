package com.company.hrs.service.dtos.address.requestes;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    private String parent_id;
    @NotBlank
    @NotNull
    @Size(min=5)
    private String name;
}
