package com.company.hrs.service.concretes;

import com.company.hrs.entities.Person;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.PersonRepository;
import com.company.hrs.service.abstracts.PersonService;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private ModelMapperService modelMapperService;
    @Override
    public DataResult<CreatedPersonResponse> create(CreatePersonRequest createPersonRequest) {
        Person p = modelMapperService.forRequest().map(createPersonRequest,Person.class);
        Person person = personRepository.save(p);
        CreatedPersonResponse response = modelMapperService.forResponse().map(person,CreatedPersonResponse.class);
        return new SuccessDataResult<CreatedPersonResponse>(response);
    }

    @Override
    public DataResult<Boolean> existsPersonByEmailAndPassword(String email, String password) {
        Boolean response = personRepository.existsPersonByEmailAndPasswordAndActive(email,password, Status.ACTIVE);
        return new SuccessDataResult<Boolean>(response);
    }

    @Override
    public DataResult<LoginPersonResponse> getPersonByEmail(String email) {
        LoginPersonResponse response = modelMapperService.forResponse().map(personRepository.getPersonByEmailAndActive(email,Status.ACTIVE),LoginPersonResponse.class);
        return new SuccessDataResult<LoginPersonResponse>(response);
    }
}
