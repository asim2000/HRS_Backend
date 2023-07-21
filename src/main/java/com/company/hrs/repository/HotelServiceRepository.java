package com.company.hrs.repository;

import com.company.hrs.entities.Hotel;
import com.company.hrs.entities.HotelService;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelServiceRepository extends JpaRepository<HotelService,Long> {
    List<HotelService> findAllByHotelAndActive(Hotel hotel, Status status);
}
