package com.company.hrs.repository;

import com.company.hrs.entities.Hotel;
import com.company.hrs.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findAllByActive(Status status);
    Hotel findByIdAndActive(Long id,Status status);
    @Query("select h from Hotel h where h.employee.id=?1 and h.active=?2")
    Hotel findByEmployeeId(Long id,Status status);
    @Query("select b.room.hotel from Booking b where b.bookingStatus='Pending' and b.active=0 and (?1<b.checkIn and ?2<b.checkOut) or (?1>b.checkIn and ?2>b.checkOut)")
    List<Hotel> getHotelsByCheckInAndCheckOut(LocalDate checkIn, LocalDate checkOut);
}
