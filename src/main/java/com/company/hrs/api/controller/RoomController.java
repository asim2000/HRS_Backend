package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.RoomService;
import com.company.hrs.service.dtos.hotel.response.GetRoomByIdForPaymentResponse;
import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.dtos.room.requests.SearchRoomRequest;
import com.company.hrs.service.dtos.room.responses.GetAllRoomsByHotelIdResponse;
import com.company.hrs.service.dtos.room.responses.GetByIdResponse;
import com.company.hrs.service.dtos.room.responses.GetRandomRoomResponse;
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
    @GetMapping("getall/{id}")
    public DataResult<List<GetAllRoomsByHotelIdResponse>> getAllRoomsByEmployeeId(@PathVariable Long id){
        return roomService.getAllByHotelId(id);
    }
    @PostMapping("getRandomRoom")
    public DataResult<GetRandomRoomResponse> GetRandomRoom(@RequestBody @Valid SearchRoomRequest searchRoomRequest){
        return roomService.getRandomRoom(searchRoomRequest);
    }
    @GetMapping("getbyid/{id}")
    public DataResult<GetByIdResponse> getById(@PathVariable Long id){
        return roomService.getById(id);
    }
    @GetMapping("getbyidforpayment/{id}")
    public DataResult<GetRoomByIdForPaymentResponse> getByIdForPayment(@PathVariable Long id){
        return roomService.getRoomByIdForPayment(id);
    }
}
