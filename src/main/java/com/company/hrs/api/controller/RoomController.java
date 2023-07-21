package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.RoomService;
import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.dtos.room.responses.GetAllRoomsByHotelIdResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
@RequiredArgsConstructor
@CrossOrigin
public class RoomController {
    private final RoomService roomService;
    @PostMapping("create")
    public Result create(@RequestBody @Valid CreateRoomRequest createRoomRequest){
        return roomService.create(createRoomRequest);
    }
    @GetMapping("getall/hotel/{id}")
    public DataResult<List<GetAllRoomsByHotelIdResponse>> getAllRoomsByEmployeeId(@PathVariable Long id){
        return roomService.getAllByHotelId(id);
    }
}
