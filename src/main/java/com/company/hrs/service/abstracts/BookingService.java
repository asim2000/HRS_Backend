package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByPersonIdResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.util.List;

public interface BookingService {
    DataResult<List<GetAllBookingsByPersonIdResponse>> getAllByPersonId(Long id);
}
