package com.company.hrs.repository;

import com.company.hrs.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,String> {
}
