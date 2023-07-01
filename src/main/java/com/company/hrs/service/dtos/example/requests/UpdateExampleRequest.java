package com.company.hrs.service.dtos.example.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateExampleRequest {
    private String id;
    private String name;
}
