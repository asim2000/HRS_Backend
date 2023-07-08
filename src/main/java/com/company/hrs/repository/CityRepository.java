package com.company.hrs.repository;

import com.company.hrs.entities.City;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Long> {
    List<City> getAllByActiveOrderByNameAsc(Status status);
    City getCityByIdAndActive(Long id,Status status);
}
