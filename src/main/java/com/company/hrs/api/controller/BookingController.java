package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.BookingService;
import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByHotelIdResponse;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByPersonIdResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @GetMapping("getallbypersonid/{id}")
    public DataResult<List<GetAllBookingsByPersonIdResponse>> getAllByPersonId(@PathVariable Long id){
        return bookingService.getAllByPersonId(id);
    }
    @GetMapping("getallbyhotelid/{id}")
    public DataResult<List<GetAllBookingsByHotelIdResponse>> getAllByHotelId(@PathVariable Long id){
        return bookingService.getAllBookingsByHotelId(id);
    }
}
