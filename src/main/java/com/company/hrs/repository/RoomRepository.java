package com.company.hrs.repository;

import com.company.hrs.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query("select r from Room r where r.active=0 and r.hotel.id=?1")
    List<Room> getAllByHotelId(Long id);
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
    List<Room> getUnReservedRooms(LocalDate checkIn, LocalDate checkOut);
}
