package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.service.dtos.hotel.response.GetAllHomeHotelResponse;
import com.company.hrs.service.dtos.hotel.response.GetHotelDetailsResponse;

import java.util.List;

public interface HotelService {
     void create(CreateHotelRequest request);
     List<GetAllHomeHotelResponse> getAllHomeHotels();
     GetHotelDetailsResponse getHotelDetails(Long id);
}
