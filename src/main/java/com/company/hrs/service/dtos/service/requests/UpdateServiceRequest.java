package com.company.hrs.service.dtos.service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateServiceRequest {
    private Long id;
    private String name;
}
