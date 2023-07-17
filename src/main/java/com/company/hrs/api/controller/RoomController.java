package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.RoomService;
import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    public Result create(CreateRoomRequest createRoomRequest){
        return roomService.create(createRoomRequest);
    }
}
