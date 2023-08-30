package com.company.hrs.service.dtos.booking.requests;

import com.company.hrs.service.dtos.person.requests.CreateCustomerForHotelOrBroker;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingForCustomerRequest {
    @Column(name = "ordered_id")
    @NotNull
    private Long orderedId;
    @NotNull
    @Column(name = "orderer_id")
    private Long ordererId;
    @Column(name = "room_id")
    @NotNull
    private Long roomId;
    @Column(name = "check_in")
    @NotNull
    private LocalDate checkIn;
    @Column(name = "check_out")
    @NotNull
    private LocalDate checkOut;
    @NotNull
    private Float pricePerNight;
}
