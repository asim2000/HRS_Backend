package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Person;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;
import com.company.hrs.service.result.DataResult;

public interface PersonService {
    DataResult<CreatedPersonResponse> create(CreatePersonRequest createPersonRequest);
    DataResult<Boolean> existsPersonByEmailAndPassword(String email,String password);
    DataResult<LoginPersonResponse> getPersonByEmail(String email);
}
