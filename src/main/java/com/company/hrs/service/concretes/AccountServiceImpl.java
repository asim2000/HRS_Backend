package com.company.hrs.service.concretes;

import com.company.hrs.entities.*;
import com.company.hrs.enums.Position;
import com.company.hrs.security.JwtTokenProvider;
import com.company.hrs.service.abstracts.*;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
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
import com.company.hrs.service.dtos.personRole.requests.CreatePersonRoleRequest;
import com.company.hrs.service.dtos.role.requests.CreateRoleRequest;
import com.company.hrs.service.dtos.role.responses.CreatedRoleResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.service.rules.AccountServiceRules;
import com.company.hrs.utils.mappers.ModelMapperService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final PersonRoleService personRoleService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result register(RegisterRequest request) {
        accountServiceRules.checkIfPersonEmailExists(request.getEmail());

        CreateAddressRequest address = new CreateAddressRequest();
        address.setCityId(request.getCityId());
        address.setAddressLine(request.getAddressLine());
        CreatedAddressResponse createdAddress = addressService.create(address).getData();

        CreateContactRequest contact = new CreateContactRequest();
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        CreatedContactResponse createdContact = contactService.create(contact).getData();

        CreatePersonRequest createPersonRequest = new CreatePersonRequest();
        createPersonRequest.setAddressId(createdAddress.getId());
        createPersonRequest.setContactId(createdContact.getId());
        createPersonRequest.setName(request.getName());
        createPersonRequest.setSurname(request.getSurname());
        createPersonRequest.setGender(request.getGender());
        createPersonRequest.setImage(request.getImage());
        createPersonRequest.setPassword(passwordEncoder.encode(request.getPassword()));
        createPersonRequest.setDateOfBirth(request.getDateOfBirth());
        Role role = null;
        if(roleService.existsRoleByNameIgnoreCase(request.getRole()).getCode() == StatusCode.NOT_FOUND){
            DataResult<CreatedRoleResponse> createdRoleResponse = roleService.create(new CreateRoleRequest(request.getRole()));
            if(createdRoleResponse.getCode() == StatusCode.SUCCESS){
                role = modelMapperService.forResponse().map(createdRoleResponse.getData(),Role.class);
            }
        }else{
            role = modelMapperService.forResponse().map(roleService.getRoleByNameIgnoreCase(request.getRole()).getData(),Role.class);
        }

        CreatedPersonResponse createdPerson = personService.create(createPersonRequest).getData();
        CreatePersonRoleRequest personRoleRequest = new CreatePersonRoleRequest();
        personRoleRequest.setPersonId(createdPerson.getId());
        personRoleRequest.setRoleId(role.getId());
        personRoleService.create(personRoleRequest);

        if(request.getRole().equalsIgnoreCase("hotel")){
            CreateEmployeeRequest employee = new CreateEmployeeRequest();
            employee.setPersonId(createdPerson.getId());
            employee.setPosition(Position.Admin);
            employeeService.create(employee);
        }
        return new SuccessResult();
    }

    @Override
    public DataResult<String> login(LoginRequest loginRequest) {
        accountServiceRules.checkIfPersonEmailNotExists(loginRequest.getEmail());
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        Authentication auth = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwtToken = jwtTokenProvider.generateJwtToken(modelMapperService.forResponse().map(personService.getPersonByEmail(loginRequest.getEmail()).getData(),Person.class));
        return new DataResult<>(jwtToken,StatusCode.SUCCESS, Message.SUCCESSFULLY_LOGIN);
    }
}
