package com.company.hrs.repository;

import com.company.hrs.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String> {
}
