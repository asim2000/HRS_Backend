package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.service.requests.CreateServiceRequest;
import com.company.hrs.service.dtos.service.requests.UpdateServiceRequest;
import com.company.hrs.service.dtos.service.responses.GetAllServiceResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.util.List;

public interface ServiceService {
    Result create(CreateServiceRequest createServiceRequest);
    Result update(UpdateServiceRequest updateServiceRequest);
    DataResult<List<GetAllServiceResponse>> getAll();
}
