package com.company.hrs.repository;

import com.company.hrs.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContactRepository extends JpaRepository<Contact,String> {
    boolean existsContactByEmail(String email);

}
