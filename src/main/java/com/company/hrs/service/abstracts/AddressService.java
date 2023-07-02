package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Address;
import com.company.hrs.service.dtos.address.requestes.CreateAddressRequest;
import com.company.hrs.service.dtos.address.requestes.UpdateAddressRequest;
import com.company.hrs.service.dtos.address.responses.CreatedAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetAllAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetByNameAddressResponse;

import java.util.List;

public interface AddressService {
    List<GetAllAddressResponse> getAll();
    CreatedAddressResponse create(CreateAddressRequest createAddressRequest);
    void delete(String id);
    void update(UpdateAddressRequest updateAddressRequest);
}
