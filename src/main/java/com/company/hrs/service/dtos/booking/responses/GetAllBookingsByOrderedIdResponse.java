package com.company.hrs.service.dtos.booking.responses;

import com.company.hrs.enums.BookingStatus;
import com.company.hrs.service.dtos.payment.responses.GetPaymentsByBookingResponse;
import com.company.hrs.service.dtos.person.responses.GetPersonDetailsResponse;
import com.company.hrs.service.dtos.room.responses.GetRoomDetailsResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetAllBookingsByOrderedIdResponse {
    Long id;
    GetPersonDetailsResponse orderer;
    GetRoomDetailsResponse room;
    Float pricePerNight;
    String reservationNumber;
    BookingStatus bookingStatus;
    LocalDate checkIn;
    LocalDate checkOut;
    LocalDateTime createdDate;
    List<GetPaymentsByBookingResponse> payments;
}
