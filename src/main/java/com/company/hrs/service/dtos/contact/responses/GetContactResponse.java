package com.company.hrs.service.dtos.contact.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetContactResponse {
    private Long id;
    private String phone;
    private String email;
}
