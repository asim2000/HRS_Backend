package com.company.hrs.service.concretes;

import com.company.hrs.entities.Role;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.RoleRepository;
import com.company.hrs.service.abstracts.RoleService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.role.requests.CreateRoleRequest;
import com.company.hrs.service.dtos.role.responses.CreatedRoleResponse;
import com.company.hrs.service.dtos.role.responses.GetRoleResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.rules.RoleRules;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapperService modelMapperService;
    private final RoleRules roleRules;
    @Override
    public DataResult<GetRoleResponse> getRoleByNameIgnoreCase(String name) {
        Role role = roleRepository.getRoleByActiveAndNameIgnoreCase(Status.ACTIVE,name);
        roleRules.checkIfNullRole(role);
        GetRoleResponse response = modelMapperService.forResponse().map(role,GetRoleResponse.class);
        return new SuccessDataResult<GetRoleResponse>(response);
    }

    @Override
    public DataResult<CreatedRoleResponse> create(CreateRoleRequest request) {
        roleRules.checkIfExistsRole(request.getName());
        Role role = roleRepository.save(modelMapperService.forRequest().map(request,Role.class));
        CreatedRoleResponse response = modelMapperService.forResponse().map(role, CreatedRoleResponse.class);
        return new SuccessDataResult<CreatedRoleResponse>(response);
    }

    @Override
    public DataResult<Boolean> existsRoleByNameIgnoreCase(String name) {
        Boolean response = roleRepository.existsByActiveAndNameIgnoreCase(Status.ACTIVE,name);
        if(response){
            return new SuccessDataResult<Boolean>(response);
        }else{
            return new DataResult<Boolean>(response, StatusCode.NOT_FOUND, Message.NOT_FOUND);
        }
    }
}
