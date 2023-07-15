package com.company.hrs.service.dtos.employee.requests;

import com.company.hrs.enums.Position;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    @Column(name = "person_id")
    private Long personId;
    private Position position;
}
