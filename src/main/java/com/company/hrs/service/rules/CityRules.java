package com.company.hrs.service.rules;

import com.company.hrs.entities.City;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.utils.exceptions.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityRules {
    public void checkIfNullOrEmptyCities(List<City> cities) {
        if(cities == null || cities.isEmpty()){
            throw new ServiceException(StatusCode.NOT_FOUND, Message.NOT_FOUND);
        }
    }

    public void checkIfNullCity(City city) {
        if(city == null){
            throw new ServiceException(StatusCode.NOT_FOUND, Message.NOT_FOUND);
        }
    }
}
