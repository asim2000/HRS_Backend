package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import com.company.hrs.service.result.Result;

public interface BookingService {
    Result book(CreateBookingRequest createBookRequest);
}
