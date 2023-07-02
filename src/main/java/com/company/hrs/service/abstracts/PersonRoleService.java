package com.company.hrs.service.abstracts;

import com.company.hrs.entities.PersonRole;
import com.company.hrs.service.dtos.personRole.requests.CreatePersonRoleRequest;

public interface PersonRoleService {
    void create(CreatePersonRoleRequest request);
}
