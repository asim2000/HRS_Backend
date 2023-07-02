package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ROOM_BOOKING")
public class RoomBooking extends BaseEntity{
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROOM_ID", nullable = false)
    private Room room;

    @Size(max = 30)
    @NotNull
    @Column(name = "RESERVATION_NUMBER", nullable = false, length = 30)
    private String reservationNumber;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "DURATION_IN_DAYS", nullable = false)
    private Long durationInDays;

    @Size(max = 50)
    @NotNull
    @Column(name = "BOOKING_STATUS", nullable = false, length = 50)
    private String bookingStatus;

    @NotNull
    @Column(name = "CHECK_IN", nullable = false)
    private LocalDate checkIn;

    @NotNull
    @Column(name = "CHECK_OUT", nullable = false)
    private LocalDate checkOut;
}