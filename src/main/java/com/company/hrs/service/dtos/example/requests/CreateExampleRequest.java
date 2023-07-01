package com.company.hrs.service.dtos.example.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateExampleRequest {
    @Size(min = 5,max = 10)
    @NotNull
    @NotBlank
    private String name;
}
