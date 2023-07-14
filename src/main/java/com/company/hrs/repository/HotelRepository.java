package com.company.hrs.repository;

import com.company.hrs.entities.Hotel;
import com.company.hrs.enums.Status;
import com.company.hrs.service.dtos.hotel.response.GetAllHomeHotelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findAllByActive(Status status);
}
