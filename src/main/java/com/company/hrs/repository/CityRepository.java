package com.company.hrs.repository;

import com.company.hrs.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,String> {
}
