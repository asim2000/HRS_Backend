package com.company.hrs.repository;

import com.company.hrs.service.abstracts.CustomerService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerServiceRepository extends JpaRepository<CustomerService,String> {
}
