package com.company.hrs.entities;

import com.company.hrs.enums.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity{
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false,referencedColumnName = "id")
    private Person person;
    @OneToOne(fetch = FetchType.LAZY)
    private Review review;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id",referencedColumnName = "id", nullable = false)
    private Room room;

    @OneToMany(mappedBy = "booking",fetch = FetchType.LAZY)
    private List<Payment> payments;

    @Size(max = 30)
    @NotNull
    @Column(name = "reservation_number", nullable = false, length = 30)
    private String reservationNumber;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull
    @Column(name = "duration_in_days", nullable = false)
    private Long durationInDays;

    @Size(max = 50)
    @NotNull
    @Column(name = "booking_status", nullable = false, length = 50)
    private BookingStatus bookingStatus;

    @NotNull
    @Column(name = "check_in", nullable = false)
    private LocalDate checkIn;

    @NotNull
    @Column(name = "check_out", nullable = false)
    private LocalDate checkOut;
}