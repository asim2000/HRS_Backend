package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.service.dtos.hotel.requests.SearchHotelRequest;
import com.company.hrs.service.dtos.hotel.response.GetHomeHotelsResponse;
import com.company.hrs.service.dtos.hotel.response.GetByEmployeeIdResponse;
import com.company.hrs.service.dtos.hotel.response.GetHotelDetailsResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.time.LocalDate;
import java.util.List;

public interface HotelService {
     Result create(CreateHotelRequest request);
     DataResult<List<GetHomeHotelsResponse>> getHomeHotels(SearchHotelRequest searchHotelRequest);
     DataResult<GetHotelDetailsResponse> getHotelDetails(Long id);
     DataResult<GetByEmployeeIdResponse> getByEmployeeId(Long id);
     DataResult<Boolean> checkIfExistsRoom(Long hotelId);
}
