package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.result.Result;

public interface RoomService {
    Result create(CreateRoomRequest createRoomRequest);
}
