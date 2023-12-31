package com.company.hrs.service.dtos.booking.responses;

import com.company.hrs.enums.BookingStatus;
import com.company.hrs.service.dtos.payment.responses.GetPaymentsByBookingResponse;
import com.company.hrs.service.dtos.room.responses.GetRoomDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBookingsByOrdererIdResponse {
    Long id;
    private GetRoomDetailsResponse room;
    private Float pricePerNight;
    private String reservationNumber;
    private BookingStatus bookingStatus;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private LocalDateTime createdDate;
    private List<GetPaymentsByBookingResponse> payments;
}
