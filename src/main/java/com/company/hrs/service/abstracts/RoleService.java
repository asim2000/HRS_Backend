package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Role;
import com.company.hrs.service.dtos.role.requests.CreateRoleRequest;

public interface RoleService {
    Role getRoleByNameIgnoreCase(String name);
    Role create(CreateRoleRequest request);
}
