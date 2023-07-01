package com.company.hrs.repository;

import com.company.hrs.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,String> {
    List<Address> findAll();
    List<Address> findAddressByName(String name);
    boolean existsAddressByNameIgnoreCase(String name);
}
