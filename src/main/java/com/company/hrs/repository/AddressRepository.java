package com.company.hrs.repository;

import com.company.hrs.entities.Address;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    List<Address> findAllByActive(Status status);
}
