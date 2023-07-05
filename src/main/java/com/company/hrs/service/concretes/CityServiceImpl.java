package com.company.hrs.service.concretes;

import com.company.hrs.entities.City;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.CityRepository;
import com.company.hrs.service.abstracts.CityService;
import com.company.hrs.service.dtos.city.requests.CreateCityRequest;
import com.company.hrs.service.dtos.city.requests.UpdateCityRequest;
import com.company.hrs.service.dtos.city.responses.CreatedCityResponse;
import com.company.hrs.service.dtos.city.responses.DeletedCityResponse;
import com.company.hrs.service.dtos.city.responses.GetAllCityResponse;
import com.company.hrs.service.dtos.city.responses.UpdatedCityResponse;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
    private ModelMapperService modelMapperService;
    private CityRepository cityRepository;

    @Override
    public CreatedCityResponse create(CreateCityRequest createCityRequest) {
        City city = cityRepository.save(modelMapperService.forRequest().map(createCityRequest,City.class));
        return modelMapperService.forResponse().map(city,CreatedCityResponse.class);
    }

    @Override
    public UpdatedCityResponse update(UpdateCityRequest updateCityRequest) {
        City city = cityRepository.save(modelMapperService.forRequest().map(updateCityRequest,City.class));
        return modelMapperService.forResponse().map(city,UpdatedCityResponse.class);
    }

    @Override
    public void delete(String id) {
        cityRepository.deleteById(id);
    }

    @Override
    public List<GetAllCityResponse> getAll() {
        List<City> cities = cityRepository.getAllByActiveOrderByNameAsc(Status.ACTIVE.value);
        return cities.stream().map(city -> modelMapperService.forResponse().map(city,GetAllCityResponse.class)).collect(Collectors.toList());
    }
}
