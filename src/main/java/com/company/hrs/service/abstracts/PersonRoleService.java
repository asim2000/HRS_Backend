package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.personRole.requests.CreatePersonRoleRequest;
import com.company.hrs.service.result.Result;

public interface PersonRoleService {
    Result create(CreatePersonRoleRequest createPersonRoleRequest);
}
