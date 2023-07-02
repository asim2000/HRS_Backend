package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.AddressService;
import com.company.hrs.service.dtos.address.requestes.CreateAddressRequest;
import com.company.hrs.service.dtos.address.requestes.UpdateAddressRequest;
import com.company.hrs.service.dtos.address.responses.GetAllAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetByNameAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;
    @GetMapping()
    public List<GetAllAddressResponse> getAll(){
        return addressService.getAll();
    }
    @PostMapping()
    public void create(@RequestBody @Valid CreateAddressRequest createAddressRequest){
        addressService.create(createAddressRequest);
    }
    @PutMapping()
    public void update(@RequestBody @Valid UpdateAddressRequest updateAddressRequest){
        addressService.update(updateAddressRequest);
    }
    @DeleteMapping()
    public void delete(String id){
        addressService.delete(id);
    }
}
