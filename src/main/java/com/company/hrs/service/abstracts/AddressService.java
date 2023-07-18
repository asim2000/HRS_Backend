package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Address;
import com.company.hrs.service.dtos.address.requestes.CreateAddressRequest;
import com.company.hrs.service.dtos.address.requestes.UpdateAddressRequest;
import com.company.hrs.service.dtos.address.responses.CreatedAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetAllAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetByNameAddressResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.util.List;

public interface AddressService {
    DataResult<List<GetAllAddressResponse>> getAll();
    DataResult<CreatedAddressResponse> create(CreateAddressRequest createAddressRequest);
    Result delete(Long id);
    Result update(UpdateAddressRequest updateAddressRequest);
}
