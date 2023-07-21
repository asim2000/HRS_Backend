package com.company.hrs.repository;

import com.company.hrs.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query("select r from Room r where r.active=0 and r.hotel.id=?1")
    List<Room> getAllByHotelId(Long id);
}
