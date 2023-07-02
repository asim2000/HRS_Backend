package com.company.hrs.service.dtos.contact.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateContactRequest {
    private String email;
    private String phone;
}
