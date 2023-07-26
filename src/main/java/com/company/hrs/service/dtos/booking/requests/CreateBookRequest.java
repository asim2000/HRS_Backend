package com.company.hrs.service.dtos.booking.requests;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    @Column(name = "person_id")
    @NotNull
    private Long personId;
    @Column(name = "room_id")
    @NotNull
    private Long roomId;
    @Column(name = "check_in")
    @NotNull
    private LocalDate checkIn;
    @Column(name = "check_out")
    @NotNull
    private LocalDate checkOut;

}
