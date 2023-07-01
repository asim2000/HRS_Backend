package com.company.hrs.service.concretes;

import com.company.hrs.entities.Person;
import com.company.hrs.repository.PersonRepository;
import com.company.hrs.service.abstracts.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    @Override
    public void create(Person person) {
        personRepository.save(person);
    }
}
