package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.HotelService;
import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hotel")
@RequiredArgsConstructor
@CrossOrigin
public class HotelController {
    private final HotelService hotelService;
    @PostMapping
    public void create(@RequestBody @Valid CreateHotelRequest request){
        hotelService.create(request);
    }
}
