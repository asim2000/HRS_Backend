package com.company.hrs.service.concretes;

import com.company.hrs.entities.Address;
import com.company.hrs.entities.City;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.AddressRepository;
import com.company.hrs.service.abstracts.AddressService;
import com.company.hrs.service.dtos.address.requestes.CreateAddressRequest;
import com.company.hrs.service.dtos.address.requestes.UpdateAddressRequest;
import com.company.hrs.service.dtos.address.responses.CreatedAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetAllAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetByNameAddressResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.service.rules.AddressServiceRules;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService
{
    private ModelMapperService modelMapperService;
    private AddressRepository addressRepository;
    private AddressServiceRules addressServiceRules;
    @Override
    public DataResult<List<GetAllAddressResponse>> getAll() {
        List<Address> addresses = addressRepository.findAllByActive(Status.ACTIVE);
        List<GetAllAddressResponse> response = addresses.stream().map(address -> modelMapperService.forResponse().map(address, GetAllAddressResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllAddressResponse>>(response);
    }

    @Override
    public DataResult<CreatedAddressResponse> create(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setAddressLine(createAddressRequest.getAddressLine());
        City city = new City();
        city.setId(createAddressRequest.getCityId());
        address.setCity(city);
        Address createdAddress = addressRepository.save(address);
        CreatedAddressResponse response = modelMapperService.forResponse().map(createdAddress, CreatedAddressResponse.class);
        return new SuccessDataResult<CreatedAddressResponse>(response);
    }

    @Override
    public Result delete(Long id) {
        addressRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public Result update(UpdateAddressRequest updateAddressRequest) {
        addressRepository.save(modelMapperService.forRequest().map(updateAddressRequest,Address.class));
        return new SuccessResult();
    }
}
