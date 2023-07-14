package com.company.hrs.repository;

import com.company.hrs.entities.Contact;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact,Long> {
    boolean existsContactByEmailAndActive(String email, Status status);

}
