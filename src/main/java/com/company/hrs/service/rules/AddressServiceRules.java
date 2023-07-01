package com.company.hrs.service.rules;

import com.company.hrs.repository.AddressRepository;
import com.company.hrs.utils.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceRules {
    private AddressRepository addressRepository;
    public void checkIfAddressNameExists(String name){
        if(addressRepository.existsAddressByNameIgnoreCase(name)){
            throw new ServiceException("Address name exists");
        }
    }
}
