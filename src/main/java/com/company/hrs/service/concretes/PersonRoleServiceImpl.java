package com.company.hrs.service.concretes;

import com.company.hrs.entities.PersonRole;
import com.company.hrs.repository.PersonRoleRepository;
import com.company.hrs.service.abstracts.PersonRoleService;
import com.company.hrs.service.dtos.personRole.requests.CreatePersonRoleRequest;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonRoleServiceImpl implements PersonRoleService {
    private final PersonRoleRepository personRoleRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public Result create(CreatePersonRoleRequest createPersonRoleRequest) {
        personRoleRepository.save(modelMapperService.forRequest().map(createPersonRoleRequest, PersonRole.class));
        return new SuccessResult();
    }
}
