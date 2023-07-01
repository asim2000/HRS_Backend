package com.company.hrs.repository;

import com.company.hrs.entities.RoomBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBookingRepository extends JpaRepository<RoomBooking,String> {
}
