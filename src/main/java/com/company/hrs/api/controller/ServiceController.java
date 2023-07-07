package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.ServiceService;
import com.company.hrs.service.dtos.service.requests.CreateServiceRequest;
import com.company.hrs.service.dtos.service.responses.GetAllServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
@RequiredArgsConstructor
@CrossOrigin
public class ServiceController {
    private final ServiceService serviceService;
    @GetMapping
    public List<GetAllServiceResponse> getAll(){
        return serviceService.getAll();
    }
    @PostMapping
    public void create(CreateServiceRequest request){
        serviceService.create(request);
    }
}
