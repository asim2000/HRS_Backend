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
    @Query("select h from Hotel h where h.employee.id=?1 and h.active=?2")
    Hotel findByEmployeeId(Long id,Status status);
//    @Query("select b.room " +
//            "from Booking b " +
//            "where b.active=0 " +
//            "and b.bookingStatus=1 " +
//            "and (:checkIn<=b.checkIn and b.checkIn<=:checkOut and :checkOut<=b.checkOut)" +
//            "and (:checkIn<=b.checkOut and :checkIn>=b.checkIn and :checkOut>=b.checkOut)" +
//            "and (:checkIn>=b.checkIn and :checkOut<=b.checkOut)" +
//            "and (:checkIn<=b.checkIn and :checkOut>=b.checkOut)")
    @Query("select r " +
            "from Room r " +
            "where r.id " +
            "not in(select b.room.id " +
            "from Booking b " +
            "where b.active = 0 " +
            "and b.bookingStatus = 1 " +
            "and (:checkIn<=b.checkIn and b.checkIn<=:checkOut and :checkOut<=b.checkOut)" +
            "and (:checkIn<=b.checkOut and :checkIn>=b.checkIn and :checkOut>=b.checkOut)" +
            "and (:checkIn>=b.checkIn and :checkOut<=b.checkOut)" +
            "and (:checkIn<=b.checkIn and :checkOut>=b.checkOut))")
    List<Room> getHotelsByCheckInAndCheckOut(LocalDate checkIn, LocalDate checkOut);
}
