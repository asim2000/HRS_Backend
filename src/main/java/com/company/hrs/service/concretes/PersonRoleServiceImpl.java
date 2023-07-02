package com.company.hrs.service.concretes;

import com.company.hrs.entities.PersonRole;
import com.company.hrs.repository.PersonRoleRepository;
import com.company.hrs.service.abstracts.PersonRoleService;
import com.company.hrs.service.dtos.personRole.requests.CreatePersonRoleRequest;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonRoleServiceImpl implements PersonRoleService {
    private PersonRoleRepository personRoleRepository;
    private ModelMapperService modelMapperService;
    @Override
    public void create(CreatePersonRoleRequest request) {
        personRoleRepository.save(modelMapperService.forRequest().map(request, PersonRole.class));
    }
}
