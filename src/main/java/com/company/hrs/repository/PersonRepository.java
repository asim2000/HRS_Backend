package com.company.hrs.repository;

import com.company.hrs.entities.Person;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<Person,Long> {
    @Query("select case when exists(select p.id from Person p inner join Contact c on p.contact.id=c.id where c.email=?1 and p.password=?2) then true else false end")
    boolean existsPersonByEmailAndPasswordAndActive(String id, String password, Status status);
    @Query("select p from Person p inner join Contact c on p.contact.id=c.id where p.active = 0 and c.email=?1")
    Person getPersonByEmailAndActive(String email,Status status);
}
