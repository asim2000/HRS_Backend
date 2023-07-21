package com.company.hrs.service.concretes;

import com.company.hrs.entities.Item;
import com.company.hrs.entities.Room;
import com.company.hrs.entities.RoomItem;
import com.company.hrs.repository.RoomItemRepository;
import com.company.hrs.repository.RoomRepository;
import com.company.hrs.service.abstracts.RoomService;
import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.dtos.room.responses.GetAllRoomsByHotelIdResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapperService modelMapperService;
    private final RoomItemRepository roomItemRepository;
    @Override
    public Result create(CreateRoomRequest createRoomRequest) {
        Room room = modelMapperService.forRequest().map(createRoomRequest, Room.class);
        roomRepository.saveAndFlush(room);
        createRoomRequest.getItemIds().stream().forEach(id->{
            RoomItem roomItem = new RoomItem();
            Item item = new Item();
            item.setId(id);
            roomItem.setRoom(room);
            roomItem.setItem(item);
            roomItemRepository.save(roomItem);
        });
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllRoomsByHotelIdResponse>> getAllByHotelId(Long id) {
        List<Room> rooms = roomRepository.getAllByHotelId(id);
        return new SuccessDataResult<List<GetAllRoomsByHotelIdResponse>>(rooms.stream().map(room -> modelMapperService.forResponse().map(room, GetAllRoomsByHotelIdResponse.class)).collect(Collectors.toList()));
    }
}
