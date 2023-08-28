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
    @JoinColumn(name = "ordered_id", nullable = false,referencedColumnName = "id")
    private Person ordered;
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "orderer_id", nullable = false,referencedColumnName = "id")
    private Person orderer;
    @NotNull
    @ManyToOne()
    @JoinColumn(name = "room_id",referencedColumnName = "id", nullable = false)
    private Room room;
    @NotNull
    @Column(name = "price_per_night")
    private Float pricePerNight;

    @Size(max = 40)
    @NotNull
    @Column(name = "reservation_number", nullable = false)
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
    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<Payment> payments;
}