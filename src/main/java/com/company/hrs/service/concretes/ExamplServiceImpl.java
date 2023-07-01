package com.company.hrs.service.concretes;

import com.company.hrs.entities.Example;
import com.company.hrs.repository.ExampleRepository;
import com.company.hrs.service.abstracts.ExampleService;
import com.company.hrs.service.dtos.example.requests.CreateExampleRequest;
import com.company.hrs.service.dtos.example.requests.UpdateExampleRequest;
import com.company.hrs.service.dtos.example.responses.GetAllExampleResponse;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExamplServiceImpl implements ExampleService {
    private ModelMapperService modelMapperService;
    private ExampleRepository exampleRepository;
    @Override
    public List<GetAllExampleResponse> getAll() {
        return exampleRepository.findAll().stream().map(example -> modelMapperService.forResponse().map(example,GetAllExampleResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void create(CreateExampleRequest createExampleRequest) {
        exampleRepository.save(modelMapperService.forRequest().map(createExampleRequest,Example.class));
    }

    @Override
    public void update(UpdateExampleRequest updateExampleRequest) {
        exampleRepository.save(modelMapperService.forRequest().map(updateExampleRequest,Example.class));
    }

    @Override
    public void delete(String id) {
        exampleRepository.deleteById(id);
    }
}
