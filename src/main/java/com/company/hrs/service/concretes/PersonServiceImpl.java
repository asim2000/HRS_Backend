package com.company.hrs.service.concretes;

import com.company.hrs.entities.Person;
import com.company.hrs.repository.PersonRepository;
import com.company.hrs.service.abstracts.PersonService;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private ModelMapperService modelMapperService;
    @Override
    public CreatedPersonResponse create(CreatePersonRequest createPersonRequest) {
        Person p = modelMapperService.forRequest().map(createPersonRequest,Person.class);
        Person person = personRepository.save(p);
        return modelMapperService.forResponse().map(person,CreatedPersonResponse.class);
    }
}
