package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Contact;
import com.company.hrs.service.dtos.contact.requests.CreateContactRequest;
import com.company.hrs.service.dtos.contact.responses.CreatedContactResponse;

public interface ContactService {
    CreatedContactResponse create(CreateContactRequest request);
    boolean existsContactByEmail(String email);

}
