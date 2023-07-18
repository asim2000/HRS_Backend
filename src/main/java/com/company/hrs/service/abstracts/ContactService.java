package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Contact;
import com.company.hrs.service.dtos.contact.requests.CreateContactRequest;
import com.company.hrs.service.dtos.contact.responses.CreatedContactResponse;
import com.company.hrs.service.result.DataResult;

public interface ContactService {
    DataResult<CreatedContactResponse> create(CreateContactRequest request);
    DataResult<Boolean> existsContactByEmail(String email);

}
