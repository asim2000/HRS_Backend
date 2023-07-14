package com.company.hrs.repository;

import com.company.hrs.entities.Role;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role getRoleByActiveAndNameIgnoreCase(Status status,String name);
}
