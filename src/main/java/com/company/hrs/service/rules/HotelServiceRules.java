package com.company.hrs.service.rules;

import com.company.hrs.entities.Hotel;
import com.company.hrs.repository.HotelRepository;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.utils.exceptions.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceRules {
    public void checkIfHotelListIsNull(List<Hotel> hotels){
        if(hotels==null || hotels.isEmpty()){
            throw new ServiceException(StatusCode.NOT_FOUND,Message.NOT_FOUND);
        }
    }

    public void checkIfFileNameInvalid(String originalFileName) {
        if(originalFileName.contains("..")){
            throw new ServiceException(StatusCode.INVALID_FILE_NAME,Message.INVALID_FILE_NAME);
        }
    }
}
