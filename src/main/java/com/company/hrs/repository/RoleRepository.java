package com.company.hrs.repository;

import com.company.hrs.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    boolean existsByNameIgnoreCase(String name);
    Role getRoleByNameIgnoreCase(String name);
}
