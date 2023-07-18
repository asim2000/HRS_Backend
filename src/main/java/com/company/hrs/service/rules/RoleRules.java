package com.company.hrs.service.rules;

import com.company.hrs.entities.Role;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.utils.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class RoleRules {
    public void checkIfNullRole(Role role){
        if(role == null){
            throw new ServiceException(StatusCode.NOT_FOUND, Message.NOT_FOUND);
        }
    }
}
