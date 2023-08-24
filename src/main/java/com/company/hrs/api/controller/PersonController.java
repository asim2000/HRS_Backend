package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.PersonService;
import com.company.hrs.service.dtos.person.responses.GetPersonDetailsResponse;
import com.company.hrs.service.result.DataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    @GetMapping("{id}")
    public DataResult<GetPersonDetailsResponse> getById(@PathVariable Long id){
        return personService.getById(id);
    }
}
