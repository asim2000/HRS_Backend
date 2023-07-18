package com.company.hrs.service.concretes;

import com.company.hrs.entities.City;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.CityRepository;
import com.company.hrs.service.abstracts.CityService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.city.requests.CreateCityRequest;
import com.company.hrs.service.dtos.city.requests.UpdateCityRequest;
import com.company.hrs.service.dtos.city.responses.*;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.service.rules.CityRules;
import com.company.hrs.utils.exceptions.ServiceException;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final ModelMapperService modelMapperService;
    private final CityRepository cityRepository;
    private final CityRules cityRules;

    @Override
    public Result create(CreateCityRequest createCityRequest) {
        cityRepository.save(modelMapperService.forRequest().map(createCityRequest,City.class));
        return new SuccessResult();
    }

    @Override
    public Result update(UpdateCityRequest updateCityRequest) {
        cityRepository.save(modelMapperService.forRequest().map(updateCityRequest,City.class));
        return new SuccessResult();
    }

    @Override
    public Result delete(Long id) {
        cityRepository.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllCityResponse>> getAll() {
        List<City> cities = cityRepository.getAllByActiveOrderByNameAsc(Status.ACTIVE);
        cityRules.checkIfNullOrEmptyCities(cities);
        List<GetAllCityResponse> response = cities.stream().map(city -> modelMapperService.forResponse().map(city,GetAllCityResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllCityResponse>>(response);
    }

    @Override
    public DataResult<GetCityResponse> getById(Long id) {
        City city = cityRepository.getCityByIdAndActive(id,Status.ACTIVE);
        cityRules.checkIfNullCity(city);
        GetCityResponse response = modelMapperService.forResponse().map(city,GetCityResponse.class);
        return new SuccessDataResult<GetCityResponse>(response);
    }
}
