package com.company.hrs.service.rules;

import com.company.hrs.entities.Person;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.utils.exceptions.ServiceException;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceRules {
    public void checkIfFileNameInvalid(String originalFileName) {
        if(originalFileName.contains("..")){
            throw new ServiceException(StatusCode.INVALID_FILE_NAME, Message.INVALID_FILE_NAME);
        }
    }

    public void checkIfPersonIsNull(Person person) {
        if(person == null) {
            throw new ServiceException(StatusCode.PERSON_NOT_FOUND,Message.PERSON_NOT_FOUND);
        }
    }
}
