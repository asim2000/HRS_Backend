package com.company.hrs.repository;

import com.company.hrs.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomBookingRepository extends JpaRepository<Booking,Long> {
}
