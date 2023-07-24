package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.HotelService;
import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.service.dtos.hotel.requests.SearchHotelRequest;
import com.company.hrs.service.dtos.hotel.response.GetHomeHotelsResponse;
import com.company.hrs.service.dtos.hotel.response.GetByEmployeeIdResponse;
import com.company.hrs.service.dtos.hotel.response.GetHotelDetailsResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
@RequiredArgsConstructor
@CrossOrigin
public class HotelController {
    private final HotelService hotelService;
    @PostMapping()
    public Result create(@ModelAttribute() @Valid CreateHotelRequest request){
        return hotelService.create(request);
    }

    @PostMapping("home/getall")
    public DataResult<List<GetHomeHotelsResponse>> getHomeHotels(@RequestBody SearchHotelRequest request){
        return hotelService.getHomeHotels(request);
    }
    @GetMapping("details/{id}")
    public DataResult<GetHotelDetailsResponse> getHotelDetails(@PathVariable Long id){
        return hotelService.getHotelDetails(id);
    }
    @GetMapping("employee/{id}")
    public DataResult<GetByEmployeeIdResponse> getByEmployeeId(@PathVariable Long id){
        return hotelService.getByEmployeeId(id);
    }
}
