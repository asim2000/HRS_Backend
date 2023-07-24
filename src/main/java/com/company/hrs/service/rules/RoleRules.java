package com.company.hrs.service.rules;

import com.company.hrs.entities.Role;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.RoleRepository;
import com.company.hrs.service.abstracts.RoleService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.utils.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleRules {
    private final RoleRepository roleRepository;
    public void checkIfNullRole(Role role){
        if(role == null){
            throw new ServiceException(StatusCode.NOT_FOUND, Message.NOT_FOUND);
        }
    }

    public void checkIfExistsRole(String name) {
        if(roleRepository.existsByActiveAndNameIgnoreCase(Status.ACTIVE,name)){
            throw new ServiceException(StatusCode.ROLE_EXISTS,Message.ROLE_EXISTS);
        }
    }
}
