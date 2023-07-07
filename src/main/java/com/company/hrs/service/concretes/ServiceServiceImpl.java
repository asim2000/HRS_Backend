package com.company.hrs.service.concretes;

import com.company.hrs.enums.Status;
import com.company.hrs.repository.ServiceRepository;
import com.company.hrs.service.abstracts.ServiceService;
import com.company.hrs.service.dtos.service.requests.CreateServiceRequest;
import com.company.hrs.service.dtos.service.requests.UpdateServiceRequest;
import com.company.hrs.service.dtos.service.responses.GetAllServiceResponse;
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
    @Override
    public void create(CreateServiceRequest createServiceRequest) {
        serviceRepository.save(modelMapperService.forRequest().map(createServiceRequest, com.company.hrs.entities.Service.class));
    }

    @Override
    public void update(UpdateServiceRequest updateServiceRequest) {
        serviceRepository.save(modelMapperService.forRequest().map(updateServiceRequest, com.company.hrs.entities.Service.class));
    }

    @Override
    public List<GetAllServiceResponse> getAll() {
        List<com.company.hrs.entities.Service> services = serviceRepository.findAllByActive(Status.ACTIVE);
        return services.stream().map(service -> modelMapperService.forResponse().map(service,GetAllServiceResponse.class)).collect(Collectors.toList());
    }
}
