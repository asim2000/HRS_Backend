package com.company.hrs.service.concretes;

import com.company.hrs.entities.Hotel;
import com.company.hrs.entities.Item;
import com.company.hrs.entities.Room;
import com.company.hrs.entities.RoomItem;
import com.company.hrs.repository.RoomItemRepository;
import com.company.hrs.repository.RoomRepository;
import com.company.hrs.service.abstracts.ItemService;
import com.company.hrs.service.abstracts.RoomService;
import com.company.hrs.service.dtos.hotel.response.GetRoomByIdForPaymentResponse;
import com.company.hrs.service.dtos.item.responses.GetAllItemResponse;
import com.company.hrs.service.dtos.room.requests.CreateRoomRequest;
import com.company.hrs.service.dtos.room.requests.SearchRoomRequest;
import com.company.hrs.service.dtos.room.responses.*;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.service.rules.RoomServiceRules;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ModelMapperService modelMapperService;
    private final RoomItemRepository roomItemRepository;
    private final RoomServiceRules roomServiceRules;
    private final ItemService itemService;
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

    @Override
    public DataResult<List<GetUnReservedRoomsResponse>> getUnReservedRooms(LocalDate checkIn, LocalDate checkOut) {
        List<Room> rooms = roomRepository.getUnReservedRooms(checkIn,checkOut);
        return new SuccessDataResult<List<GetUnReservedRoomsResponse>>(rooms.stream().map(room -> modelMapperService.forResponse().map(room, GetUnReservedRoomsResponse.class)).collect(Collectors.toList()));
    }

    @Override
    public DataResult<GetRandomRoomResponse> getRandomRoom(SearchRoomRequest searchRoomRequest) {
        List<Room> rooms = roomRepository.getUnReservedRoomsByHotelId(searchRoomRequest.getCheckIn(),searchRoomRequest.getCheckOut(),searchRoomRequest.getHotelId());
        if(searchRoomRequest.getRoomCount()!=null){
            List<Room> roomList = new ArrayList<>();
            rooms.stream().forEach(room ->  {
                if(room.getRoomCount()==searchRoomRequest.getRoomCount())
                    roomList.add(room);
            });
            rooms = roomList;
        }
        if(searchRoomRequest.getAdultCount()!=null){
            List<Room> roomList = new ArrayList<>();
            rooms.stream().forEach(room ->  {
                if(room.getAdultCount()>=searchRoomRequest.getAdultCount())
                    roomList.add(room);
            });
            rooms = roomList;
        }
        if(searchRoomRequest.getChildreenCount()!=null){
            List<Room> roomList = new ArrayList<>();
            rooms.stream().forEach(room ->  {
                if(room.getChildreenCount()>=searchRoomRequest.getChildreenCount())
                    roomList.add(room);
            });
            rooms = roomList;
        }
        if(searchRoomRequest.getRoomStyle() != null){
            List<Room> roomList = new ArrayList<>();
            rooms.stream().forEach(room ->  {
                if(room.getRoomStyle() == searchRoomRequest.getRoomStyle())
                    roomList.add(room);
            });
            rooms = roomList;
        }
        roomServiceRules.checkIfRoomsIsNullOrEmpty(rooms);
        Room room = rooms.get(ThreadLocalRandom.current().nextInt(0, rooms.size()));
        GetRandomRoomResponse response = modelMapperService.forResponse().map(room,GetRandomRoomResponse.class);
        response.setItems(itemService.getAllByRoomId(room.getId()).getData());
        return new SuccessDataResult<GetRandomRoomResponse>(response);
    }

    @Override
    public DataResult<GetByIdResponse> getById(Long id) {
        Room room = roomRepository.getById(id);
        return new SuccessDataResult<GetByIdResponse>(modelMapperService.forResponse().map(room, GetByIdResponse.class));
    }

    @Override
    public DataResult<GetRoomByIdForPaymentResponse> getRoomByIdForPayment(Long id) {
        Room room = roomRepository.getById(id);
        GetRoomByIdForPaymentResponse response = modelMapperService.forResponse().map(room,GetRoomByIdForPaymentResponse.class);
        return new SuccessDataResult<>(response);
    }
}
