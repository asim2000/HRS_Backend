package com.company.hrs.api.controller;

import com.company.hrs.entities.Example;
import com.company.hrs.service.abstracts.ExampleService;
import com.company.hrs.service.dtos.example.requests.CreateExampleRequest;
import com.company.hrs.service.dtos.example.requests.UpdateExampleRequest;
import com.company.hrs.service.dtos.example.responses.GetAllExampleResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("example")
@AllArgsConstructor
public class ExampleController {
    private ExampleService exampleService;
    @GetMapping()
    public List<GetAllExampleResponse> getAll(){
        return exampleService.getAll();
    }
    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@Valid @RequestBody CreateExampleRequest createExampleRequest){
        exampleService.create(createExampleRequest);
    }
    @PutMapping()
    public void update(UpdateExampleRequest updateExampleRequest){
        exampleService.update(updateExampleRequest);
    }
    @DeleteMapping()
    public void delete(String id){
        exampleService.delete(id);
    }
}
