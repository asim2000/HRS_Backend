package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.PersonService;
import com.company.hrs.service.dtos.person.responses.GetPersonDetailsResponse;
import com.company.hrs.service.result.DataResult;
import jdk.jfr.DataAmount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;
    @GetMapping("{id}")
    public DataResult<GetPersonDetailsResponse> getById(@PathVariable Long id){
        return personService.getById(id);
    }
    @GetMapping
    public DataResult<GetPersonDetailsResponse> getByEmail(@RequestParam String email) {
        return personService.getByEmail(email);
    }
}
