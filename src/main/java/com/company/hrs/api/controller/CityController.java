package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.CityService;
import com.company.hrs.service.dtos.city.requests.CreateCityRequest;
import com.company.hrs.service.dtos.city.requests.UpdateCityRequest;
import com.company.hrs.service.dtos.city.responses.CreatedCityResponse;
import com.company.hrs.service.dtos.city.responses.GetAllCityResponse;
import com.company.hrs.service.dtos.city.responses.UpdatedCityResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("city")
@AllArgsConstructor
public class CityController {
    private CityService cityService;
    @PostMapping
    public CreatedCityResponse create(CreateCityRequest createCityRequest){
        return cityService.create(createCityRequest);
    }
    @PutMapping
    public UpdatedCityResponse update(UpdateCityRequest updateCityRequest){
        return cityService.update(updateCityRequest);
    }
    @DeleteMapping
    public void delete(String id){
        cityService.delete(id);
    }
    @GetMapping
    public List<GetAllCityResponse> getAll(){
        return cityService.getAll();
    }
}