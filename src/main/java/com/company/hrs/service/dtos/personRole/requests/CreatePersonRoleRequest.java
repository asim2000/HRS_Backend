package com.company.hrs.service.dtos.personRole.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRoleRequest {
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "role_id")
    private Long roleId;
}
