package com.company.hrs.repository;

import com.company.hrs.entities.Hotel;
import com.company.hrs.enums.Status;
import com.company.hrs.service.dtos.hotel.response.GetAllHomeHotelResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
//    @Query("select new com.company.hrs.service.dtos.hotel.response.GetAllHomeHotelResponse(h.id,h.name,h.rating,0,a,c)" +
//            " from Hotel h " +
//            "inner join Address a " +
//            "on h.address.id=a.id " +
//            "inner join Contact c " +
//            "on h.contact.id=c.id " +
//            "where h.active=1")
    List<Hotel> findAll();
}
