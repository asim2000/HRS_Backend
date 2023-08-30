package com.company.hrs.repository;

import com.company.hrs.entities.Booking;
import com.company.hrs.entities.Hotel;
import com.company.hrs.enums.Status;
import com.company.hrs.service.dtos.hotel.response.GetHotelReportResponse;
import com.company.hrs.service.dtos.hotel.response.GetOtherReportResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
    List<Hotel> findAllByActive(Status status);
    Hotel findByIdAndActive(Long id,Status status);
    @Query("select e.hotel from Employee e where e.person.id=?1 and e.hotel.active=?2")
    Hotel findByPersonId(Long id, Status status);
    @Query("select min(r.pricePerNight) from Room r where r.hotel.id = :id and r.active=0")
    Float getMinimumPriceByHotelId(Long id);
    @Query("SELECT NEW com.company.hrs.service.dtos.hotel.response.GetHotelReportResponse(" +
            "    CAST(COUNT(b.id) AS INTEGER)," +
            "    CAST(SUM(b.pricePerNight * (FUNCTION('TIMESTAMPDIFF', DAY, b.checkIn, b.checkOut) + 1)) AS FLOAT)," +
            "    CAST(SUM(b.pricePerNight * (FUNCTION('TIMESTAMPDIFF', DAY, b.checkIn, b.checkOut) + 1)) AS FLOAT)" +
            ")" +
            "FROM Booking b " +
            "WHERE b.active = 0" +
            "    AND b.room.hotel.id = :id" +
            "    AND b.ordered.id IN (" +
            "        SELECT e.person.id" +
            "        FROM Employee e" +
            "        WHERE e.active = 0" +
            "            AND e.hotel.id = :id" +
            "    )")
    GetHotelReportResponse getReportOfHotel(Long id);
    @Query("SELECT NEW com.company.hrs.service.dtos.hotel.response.GetOtherReportResponse(" +
            "    CAST(COUNT(b.id) AS INTEGER)," +
            "    CAST(SUM(b.pricePerNight * (FUNCTION('TIMESTAMPDIFF', DAY, b.checkIn, b.checkOut) + 1)) AS FLOAT)," +
            "    CAST(SUM(b.pricePerNight * (FUNCTION('TIMESTAMPDIFF', DAY, b.checkIn, b.checkOut) + 1)) -SUM(b.pricePerNight * (FUNCTION('TIMESTAMPDIFF', DAY, b.checkIn, b.checkOut) + 1))*:perCent/100 AS FLOAT)" +
            ")" +
            "FROM Booking b " +
            "WHERE b.active = 0" +
            "    AND b.room.hotel.id = :id" +
            "    AND b.ordered.id NOT IN (" +
            "        SELECT e.person.id" +
            "        FROM Employee e" +
            "        WHERE e.active = 0" +
            "            AND e.hotel.id = :id" +
            "    )")
    GetOtherReportResponse getReportOfOther(Long id,Float perCent);
}
