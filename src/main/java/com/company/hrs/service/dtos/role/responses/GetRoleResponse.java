package com.company.hrs.service.dtos.role.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetRoleResponse {
    private Long id;
    private String name;
}
