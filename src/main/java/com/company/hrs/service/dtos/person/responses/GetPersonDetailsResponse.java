package com.company.hrs.service.dtos.person.responses;

import com.company.hrs.service.dtos.contact.responses.GetContactResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPersonDetailsResponse {
    private Long id;
    private String name;
    private String surname;
    private GetContactResponse contact;
    private String image;
}
