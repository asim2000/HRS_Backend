package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Role;
import com.company.hrs.service.dtos.role.requests.CreateRoleRequest;
import com.company.hrs.service.dtos.role.responses.CreatedRoleResponse;
import com.company.hrs.service.dtos.role.responses.GetRoleResponse;
import com.company.hrs.service.result.DataResult;

public interface RoleService {
    DataResult<GetRoleResponse> getRoleByNameIgnoreCase(String name);
    DataResult<CreatedRoleResponse> create(CreateRoleRequest request);
    DataResult<Boolean> existsRoleByNameIgnoreCase(String name);
}
