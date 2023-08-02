package com.company.hrs.repository;

import com.company.hrs.entities.PersonRole;
import com.company.hrs.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRoleRepository extends JpaRepository<PersonRole,Long> {
    @Query("select pr.role.name from PersonRole pr where pr.active=0 and pr.person.id=:id")
    List<String> getRoleNamesByPersonId(Long id);
}
