package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.dtos.room.responses.GetAllRoomsByHotelIdResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.util.List;

public interface RoomService {
    Result create(CreateRoomRequest createRoomRequest);
    DataResult<List<GetAllRoomsByHotelIdResponse>> getAllByHotelId(Long id);
}
