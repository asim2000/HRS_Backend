package com.company.hrs.entities;

import com.company.hrs.enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends BaseEntity{
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false,referencedColumnName = "id")
    private Person person;
    @OneToOne()
    private Review review;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "room_id",referencedColumnName = "id", nullable = false)
    private Room room;

    @Size(max = 30)
    @NotNull
    @Column(name = "reservation_number", nullable = false, length = 30)
    private String reservationNumber;

    @NotNull
    @Column(name = "booking_status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @NotNull
    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;

    @NotNull
    @Column(name = "check_out", nullable = false)
    private LocalDate checkOut;
}