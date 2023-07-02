package com.company.hrs.service.dtos.personRole.requests;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRoleRequest {
    @Column(name = "PERSON_ID")
    private String personId;
    @Column(name = "ROLE_ID")
    private String roleId;
}
