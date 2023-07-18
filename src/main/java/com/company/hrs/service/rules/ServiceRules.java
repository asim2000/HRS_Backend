package com.company.hrs.service.rules;

import com.company.hrs.entities.Service;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.utils.exceptions.ServiceException;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceRules {
    public void checkIfIsNullOrEmptyServices(List<Service> services){
        if(services == null || services.isEmpty()){
            throw new ServiceException(StatusCode.NOT_FOUND, Message.NOT_FOUND);
        }
    }
}
