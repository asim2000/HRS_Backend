package com.company.hrs.repository;

import com.company.hrs.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,String> {
}
