package com.company.hrs.service.concretes;

import com.company.hrs.entities.Address;
import com.company.hrs.repository.AddressRepository;
import com.company.hrs.service.abstracts.AddressService;
import com.company.hrs.service.dtos.address.requestes.CreateAddressRequest;
import com.company.hrs.service.dtos.address.requestes.UpdateAddressRequest;
import com.company.hrs.service.dtos.address.responses.GetAllAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetByNameAddressResponse;
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
    public List<GetAllAddressResponse> getAll() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(address -> modelMapperService.forResponse().map(address, GetAllAddressResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void create(CreateAddressRequest createAddressRequest) {
        addressServiceRules.checkIfAddressNameExists(createAddressRequest.getName());
        Address address = modelMapperService.forRequest().map(createAddressRequest,Address.class);
        addressRepository.save(address);
    }

    @Override
    public void delete(String id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void update(UpdateAddressRequest updateAddressRequest) {
        addressRepository.save(modelMapperService.forRequest().map(updateAddressRequest,Address.class));
    }

    @Override
    public List<GetByNameAddressResponse> getByName(String name) {
        List<Address> addresses = addressRepository.findAddressByName(name);
        return addresses.stream().map(address -> modelMapperService.forResponse().map(address, GetByNameAddressResponse.class)).collect(Collectors.toList());
    }
}
