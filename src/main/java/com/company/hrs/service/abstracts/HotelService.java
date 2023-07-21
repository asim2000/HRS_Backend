package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.service.dtos.hotel.response.GetAllHomeHotelResponse;
import com.company.hrs.service.dtos.hotel.response.GetByEmployeeIdResponse;
import com.company.hrs.service.dtos.hotel.response.GetHotelDetailsResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.util.List;

public interface HotelService {
     Result create(CreateHotelRequest request);
     DataResult<List<GetAllHomeHotelResponse>> getAllHomeHotels();
     DataResult<GetHotelDetailsResponse> getHotelDetails(Long id);
     DataResult<GetByEmployeeIdResponse> getByEmployeeId(Long id);
}
