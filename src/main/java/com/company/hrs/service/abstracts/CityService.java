package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.city.requests.CreateCityRequest;
import com.company.hrs.service.dtos.city.requests.UpdateCityRequest;
import com.company.hrs.service.dtos.city.responses.CreatedCityResponse;
import com.company.hrs.service.dtos.city.responses.DeletedCityResponse;
import com.company.hrs.service.dtos.city.responses.GetAllCityResponse;
import com.company.hrs.service.dtos.city.responses.UpdatedCityResponse;

import java.util.List;

public interface CityService {
    CreatedCityResponse create(CreateCityRequest createCityRequest);
    UpdatedCityResponse update(UpdateCityRequest updateCityRequest);
    void delete(Long id);
    List<GetAllCityResponse> getAll();
}
