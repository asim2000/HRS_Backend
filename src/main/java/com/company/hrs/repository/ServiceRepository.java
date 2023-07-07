package com.company.hrs.repository;

import com.company.hrs.entities.Service;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Long> {
    List<Service> findAllByActive(Status status);
}
