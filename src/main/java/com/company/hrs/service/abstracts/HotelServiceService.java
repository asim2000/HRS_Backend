package com.company.hrs.service.abstracts;

import com.company.hrs.entities.Hotel;
import com.company.hrs.service.dtos.hotelService.responses.GetAllServiceByHotelResponse;

import java.util.List;

public interface HotelServiceService {
    List<GetAllServiceByHotelResponse> getAllServiceByHotel(Hotel hotel);
}
