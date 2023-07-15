package com.company.hrs.service.concretes;

import com.company.hrs.entities.*;
import com.company.hrs.enums.Position;
import com.company.hrs.service.abstracts.*;
import com.company.hrs.service.dtos.account.requests.LoginRequest;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import com.company.hrs.service.dtos.address.requestes.CreateAddressRequest;
import com.company.hrs.service.dtos.address.responses.CreatedAddressResponse;
import com.company.hrs.service.dtos.contact.requests.CreateContactRequest;
import com.company.hrs.service.dtos.contact.responses.CreatedContactResponse;
import com.company.hrs.service.dtos.employee.requests.CreateEmployeeRequest;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;
import com.company.hrs.service.dtos.role.requests.CreateRoleRequest;
import com.company.hrs.service.rules.AccountServiceRules;
import com.company.hrs.utils.mappers.ModelMapperService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final PersonService personService;
    private final AddressService addressService;
    private final RoleService roleService;
    private final AccountServiceRules accountServiceRules;
    private final ModelMapperService modelMapperService;
    private final ContactService contactService;
    private final EmployeeService employeeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(RegisterRequest request) {
        accountServiceRules.checkIfPersonEmailExists(request.getEmail());

        CreateAddressRequest address = new CreateAddressRequest();
        address.setCityId(request.getCityId());
        address.setAddressLine(request.getAddressLine());
        CreatedAddressResponse createdAddress = addressService.create(address);

        CreateContactRequest contact = new CreateContactRequest();
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        CreatedContactResponse createdContact = contactService.create(contact);

        CreatePersonRequest createPersonRequest = new CreatePersonRequest();
        createPersonRequest.setAddressId(createdAddress.getId());
        createPersonRequest.setContactId(createdContact.getId());
        createPersonRequest.setName(request.getName());
        createPersonRequest.setSurname(request.getSurname());
        createPersonRequest.setGender(request.getGender());
        createPersonRequest.setImage(request.getImage());
        createPersonRequest.setPassword(request.getPassword());
        createPersonRequest.setDateOfBirth(request.getDateOfBirth());
        Role role = null;
        if((role = roleService.getRoleByNameIgnoreCase(request.getRole()))==null){
            role = roleService.create(new CreateRoleRequest(request.getRole()));
        }
        createPersonRequest.getRoles().add(role);
        CreatedPersonResponse createdPerson = personService.create(createPersonRequest);

        if(request.getRole().equalsIgnoreCase("hotel")){
            CreateEmployeeRequest employee = new CreateEmployeeRequest();
            employee.setPersonId(createdPerson.getId());
            employee.setPosition(Position.Admin);
            employeeService.create(employee);
        }
    }

    @Override
    public LoginPersonResponse login(LoginRequest loginRequest) {
        accountServiceRules.checkIfPersonEmailNotExists(loginRequest.getEmail());
        accountServiceRules.checkIfPersonPasswordConfirm(loginRequest);
        return personService.getPersonByEmail(loginRequest.getEmail());

    }
}
