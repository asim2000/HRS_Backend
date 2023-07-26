package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.dtos.room.requests.SearchRoomRequest;
import com.company.hrs.service.dtos.room.responses.*;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    Result create(CreateRoomRequest createRoomRequest);
    DataResult<List<GetAllRoomsByHotelIdResponse>> getAllByHotelId(Long id);
    DataResult<List<GetUnReservedRoomsResponse>> getUnReservedRooms(LocalDate checkIn,LocalDate checkOut);
    DataResult<GetRandomRoomResponse> getRandomRoom(SearchRoomRequest searchRoomRequest);
    DataResult<GetByIdResponse> getById(Long id);
}
