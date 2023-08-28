package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByHotelIdResponse;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByOrderedIdResponse;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByOrdererIdResponse;
import com.company.hrs.service.result.DataResult;

import java.util.List;

public interface BookingService {
    DataResult<List<GetAllBookingsByOrdererIdResponse>> getAllByPersonId(Long id);
    DataResult<List<GetAllBookingsByHotelIdResponse>> getAllBookingsByHotelId(Long id);

    DataResult<List<GetAllBookingsByOrderedIdResponse>> getAllByOrderedId(Long id);
}
