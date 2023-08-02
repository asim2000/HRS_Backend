package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.ServiceService;
import com.company.hrs.service.dtos.service.requests.CreateServiceRequest;
import com.company.hrs.service.dtos.service.responses.GetAllServiceResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceService serviceService;
    @GetMapping
    public DataResult<List<GetAllServiceResponse>> getAll(){
        return serviceService.getAll();
    }
    @PostMapping
    public Result create(CreateServiceRequest request){
        return serviceService.create(request);
    }
}
