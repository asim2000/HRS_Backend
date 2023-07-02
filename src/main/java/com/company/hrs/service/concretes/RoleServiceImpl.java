package com.company.hrs.service.concretes;

import com.company.hrs.entities.Role;
import com.company.hrs.repository.RoleRepository;
import com.company.hrs.service.abstracts.RoleService;
import com.company.hrs.service.dtos.role.requests.CreateRoleRequest;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    private ModelMapperService modelMapperService;
    @Override
    public Role getRoleByNameIgnoreCase(String name) {
        return roleRepository.getRoleByNameIgnoreCase(name);
    }

    @Override
    public Role create(CreateRoleRequest request) {
        return roleRepository.save(modelMapperService.forRequest().map(request,Role.class));
    }
}
