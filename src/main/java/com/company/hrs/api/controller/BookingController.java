package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.BookingService;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByHotelIdResponse;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByOrderedIdResponse;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByOrdererIdResponse;
import com.company.hrs.service.result.DataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @GetMapping("orderer/{id}")
    public DataResult<List<GetAllBookingsByOrdererIdResponse>> getAllByCustomerId(@PathVariable Long id){
        return bookingService.getAllByPersonId(id);
    }
    @GetMapping("ordered/{id}")
    public DataResult<List<GetAllBookingsByOrderedIdResponse>> getAllByOrderedId(@PathVariable Long id){
        return bookingService.getAllByOrderedId(id);
    }
    @GetMapping("hotel/{id}")
    public DataResult<List<GetAllBookingsByHotelIdResponse>> getAllByHotelId(@PathVariable Long id){
        DataResult<List<GetAllBookingsByHotelIdResponse>> result =  bookingService.getAllBookingsByHotelId(id);
        return result;
    }
}
