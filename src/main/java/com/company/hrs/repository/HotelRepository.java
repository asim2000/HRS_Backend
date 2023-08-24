package com.company.hrs.repository;

import com.company.hrs.entities.Hotel;
import com.company.hrs.entities.Room;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findAllByActive(Status status);
    Hotel findByIdAndActive(Long id,Status status);
    @Query("select h from Hotel h where h.employee.person.id=?1 and h.active=?2")
    Hotel findByEmployeeId(Long id,Status status);
    @Query("select min(r.pricePerNight) from Room r where r.hotel.id = :id and r.active=0")
    Float getMinimumPriceByHotelId(Long id);
}
