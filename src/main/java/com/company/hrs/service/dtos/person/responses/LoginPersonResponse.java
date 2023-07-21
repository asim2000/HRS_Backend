package com.company.hrs.service.dtos.person.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginPersonResponse {
    private Long id;
    private String name;
    private String surname;
}

