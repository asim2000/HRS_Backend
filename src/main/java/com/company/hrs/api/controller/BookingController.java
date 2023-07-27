package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.BookingService;
import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import com.company.hrs.service.result.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
@CrossOrigin
public class BookingController {
    private final BookingService bookingService;
    @PostMapping("book")
    public Result book(@RequestBody @Valid CreateBookingRequest createBookingRequest){
        return bookingService.book(createBookingRequest);
    }
}
