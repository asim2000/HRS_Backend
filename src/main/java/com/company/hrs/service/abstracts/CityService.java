package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.city.requests.CreateCityRequest;
import com.company.hrs.service.dtos.city.requests.UpdateCityRequest;
import com.company.hrs.service.dtos.city.responses.*;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.util.List;

public interface CityService {
    Result create(CreateCityRequest createCityRequest);
    Result update(UpdateCityRequest updateCityRequest);
    Result delete(Long id);
    DataResult<List<GetAllCityResponse>> getAll();
    DataResult<GetCityResponse> getById(Long id);
}
