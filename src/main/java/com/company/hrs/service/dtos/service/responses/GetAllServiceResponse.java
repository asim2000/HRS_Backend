package com.company.hrs.service.dtos.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllServiceResponse {
    private Long id;
    private String name;
}
