package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.HotelService;
import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.service.dtos.hotel.response.GetAllHomeHotelResponse;
import com.company.hrs.service.dtos.hotel.response.GetHotelDetailsResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("hotel")
@RequiredArgsConstructor
@CrossOrigin
public class HotelController {
    private final HotelService hotelService;
    @PostMapping()
    public void create(@ModelAttribute() CreateHotelRequest request){
        hotelService.create(request);
    }

    @GetMapping("home/all")
    public List<GetAllHomeHotelResponse> getAllHomeHotels(){
        return hotelService.getAllHomeHotels();
    }
    @GetMapping("details/{id}")
    public GetHotelDetailsResponse getHotelDetails(@PathVariable Long id){
        return hotelService.getHotelDetails(id);
    }
}
