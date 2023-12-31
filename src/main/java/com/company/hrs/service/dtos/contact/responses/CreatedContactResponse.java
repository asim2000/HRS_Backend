package com.company.hrs.service.dtos.contact.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedContactResponse {
    private Long id;
    private String email;
    private String phone;
}
