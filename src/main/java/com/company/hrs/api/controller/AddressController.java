package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.AddressService;
import com.company.hrs.service.dtos.address.requestes.CreateAddressRequest;
import com.company.hrs.service.dtos.address.requestes.UpdateAddressRequest;
import com.company.hrs.service.dtos.address.responses.GetAllAddressResponse;
import com.company.hrs.service.dtos.address.responses.GetByNameAddressResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
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
    public DataResult<List<GetAllAddressResponse>> getAll(){
        return addressService.getAll();
    }
    @PostMapping()
    public Result create(@RequestBody @Valid CreateAddressRequest createAddressRequest){
        return addressService.create(createAddressRequest);
    }
    @PutMapping()
    public Result update(@RequestBody @Valid UpdateAddressRequest updateAddressRequest){
       return addressService.update(updateAddressRequest);
    }
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Long id){
        return addressService.delete(id);
    }
}
