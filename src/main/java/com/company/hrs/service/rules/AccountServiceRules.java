package com.company.hrs.service.rules;

import com.company.hrs.repository.PersonRepository;
import com.company.hrs.service.abstracts.ContactService;
import com.company.hrs.utils.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceRules {
    private ContactService contactService;

    public void checkIfPersonEmailExists(String email){
        if(contactService.existsContactByByEmail(email)){
            throw new ServiceException("Person email exists");
        }
    }
}
