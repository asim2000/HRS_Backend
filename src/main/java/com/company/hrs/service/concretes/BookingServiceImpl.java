package com.company.hrs.service.concretes;

import com.company.hrs.service.abstracts.BookingService;
import com.company.hrs.service.dtos.booking.requests.CreateBookRequest;
import com.company.hrs.service.result.Result;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public Result book(CreateBookRequest createBookRequest) {
        return null;
    }
}
