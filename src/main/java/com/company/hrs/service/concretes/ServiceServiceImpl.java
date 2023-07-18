package com.company.hrs.service.concretes;

import com.company.hrs.enums.Status;
import com.company.hrs.repository.ServiceRepository;
import com.company.hrs.service.abstracts.ServiceService;
import com.company.hrs.service.dtos.service.requests.CreateServiceRequest;
import com.company.hrs.service.dtos.service.requests.UpdateServiceRequest;
import com.company.hrs.service.dtos.service.responses.GetAllServiceResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.service.rules.ServiceRules;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;
    private final ModelMapperService modelMapperService;
    private final ServiceRules serviceRules;
    @Override
    public Result create(CreateServiceRequest createServiceRequest) {
        serviceRepository.save(modelMapperService.forRequest().map(createServiceRequest, com.company.hrs.entities.Service.class));
        return new SuccessResult();
    }

    @Override
    public Result update(UpdateServiceRequest updateServiceRequest) {
        serviceRepository.save(modelMapperService.forRequest().map(updateServiceRequest, com.company.hrs.entities.Service.class));
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllServiceResponse>> getAll() {
        List<com.company.hrs.entities.Service> services = serviceRepository.findAllByActive(Status.ACTIVE);
        serviceRules.checkIfIsNullOrEmptyServices(services);
        List<GetAllServiceResponse> response = services.stream().map(service -> modelMapperService.forResponse().map(service,GetAllServiceResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllServiceResponse>>(response);
    }
}
