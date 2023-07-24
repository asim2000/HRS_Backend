package com.company.hrs.repository;

import com.company.hrs.entities.Booking;
import com.company.hrs.entities.Hotel;
import com.company.hrs.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
