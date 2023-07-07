package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Example;
import com.company.hrs.service.dtos.example.requests.CreateExampleRequest;
import com.company.hrs.service.dtos.example.requests.UpdateExampleRequest;
import com.company.hrs.service.dtos.example.responses.GetAllExampleResponse;

import java.util.List;

public interface ExampleService {
    List<GetAllExampleResponse> getAll();
    void create(CreateExampleRequest createExampleRequest);
    void update(UpdateExampleRequest updateExampleRequest);
    void delete(Long id);
}
