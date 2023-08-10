package com.company.hrs.repository;

import com.company.hrs.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("select e from Employee e where e.active=0 and e.person.id=:personId")
    Employee findByPersonId(Long personId);
}
