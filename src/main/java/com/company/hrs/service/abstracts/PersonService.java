package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Person;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;

public interface PersonService {
    CreatedPersonResponse create(CreatePersonRequest createPersonRequest);
}
