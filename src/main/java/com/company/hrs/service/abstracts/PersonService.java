package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Person;
import com.company.hrs.service.dtos.person.requests.CreateCustomerForHotelOrBroker;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;
import com.company.hrs.service.dtos.person.responses.GetPersonDetailsResponse;
import com.company.hrs.service.dtos.person.responses.GetPersonPasswordByEmailResponse;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import javax.xml.crypto.Data;

public interface PersonService {
    DataResult<CreatedPersonResponse> create(CreatePersonRequest createPersonRequest);
    DataResult<CreatedPersonResponse> create(CreateCustomerForHotelOrBroker customer);
    DataResult<Boolean> existsPersonByEmailAndPassword(String email,String password);
    DataResult<LoginPersonResponse> getPersonByEmail(String email);
    DataResult<GetPersonDetailsResponse> getByEmail(String email);
    DataResult<GetPersonPasswordByEmailResponse> getPersonPasswordByEmail(String email);

    DataResult<GetPersonDetailsResponse> getById(Long id);
}
