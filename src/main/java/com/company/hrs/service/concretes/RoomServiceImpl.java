package com.company.hrs.service.concretes;

import com.company.hrs.entities.Room;
import com.company.hrs.repository.RoomRepository;
import com.company.hrs.service.abstracts.RoomService;
import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public Result create(CreateRoomRequest createRoomRequest) {
        roomRepository.save(modelMapperService.forRequest().map(createRoomRequest, Room.class));
        return new SuccessResult();
    }
}
