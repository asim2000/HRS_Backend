package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.service.requests.CreateServiceRequest;
import com.company.hrs.service.dtos.service.requests.UpdateServiceRequest;
import com.company.hrs.service.dtos.service.responses.GetAllServiceResponse;

import java.util.List;

public interface ServiceService {
    void create(CreateServiceRequest createServiceRequest);
    void update(UpdateServiceRequest updateServiceRequest);
    List<GetAllServiceResponse> getAll();
}
