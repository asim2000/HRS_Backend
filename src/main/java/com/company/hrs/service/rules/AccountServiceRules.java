package com.company.hrs.service.rules;

import com.company.hrs.service.abstracts.ContactService;
import com.company.hrs.service.abstracts.PersonService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.account.requests.LoginRequest;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.utils.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceRules {
    private ContactService contactService;
    private PersonService personService;

    public void checkIfPersonEmailExists(String email){
        DataResult<Boolean> response = contactService.existsContactByEmail(email);
        if(response.getCode() == 200 && response.getData()){
            throw new ServiceException(StatusCode.EMAIL_EXISTS,Message.EMAIL_EXISTS);
        }
    }
    public void checkIfPersonEmailNotExists(String email){
        DataResult<Boolean> response = contactService.existsContactByEmail(email);
        if(response.getCode() == 200 && !response.getData()){
            throw new ServiceException(StatusCode.EMAIL_IS_NOT_AVAILABLE,Message.EMAIL_IS_NOT_AVAILABLE);
        }
    }
    public void checkIfPersonPasswordConfirm(LoginRequest loginRequest){
        DataResult<Boolean> response = personService.existsPersonByEmailAndPassword(loginRequest.getEmail(),loginRequest.getPassword());
        if(response.getCode() == 200 && !response.getData()){
            throw new ServiceException(StatusCode.PASSWORD_INCORRECT,Message.PASSWORD_INCORRECT);
        }
    }
}
