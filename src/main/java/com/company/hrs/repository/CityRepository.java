package com.company.hrs.repository;

import com.company.hrs.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,String> {
    List<City> getAllByActiveOrderByNameAsc(int active);
}
