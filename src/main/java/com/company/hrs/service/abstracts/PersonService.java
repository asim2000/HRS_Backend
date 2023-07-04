package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Person;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;

public interface PersonService {
    CreatedPersonResponse create(CreatePersonRequest createPersonRequest);
    boolean existsPersonByEmailAndPassword(String email,String password);
    LoginPersonResponse getPersonByEmail(String email);
}
