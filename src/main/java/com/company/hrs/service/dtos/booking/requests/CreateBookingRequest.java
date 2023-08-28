package com.company.hrs.service.dtos.booking.requests;

import com.company.hrs.service.dtos.person.requests.CreateCustomerForHotelOrBroker;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingRequest {
    @Column(name = "ordered_id")
    @NotNull
    private Long orderedId;
    @NotNull
    private CreateCustomerForHotelOrBroker customer;
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
