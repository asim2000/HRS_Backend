package com.company.hrs.service.rules;

import com.company.hrs.entities.Room;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.utils.exceptions.ServiceException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Component
public class RoomServiceRules {
    public void checkIfRoomsIsNullOrEmpty(List<Room> rooms) {
        if(rooms==null || rooms.isEmpty()){
            throw new ServiceException(StatusCode.ROOM_NOT_FOUND_Exception, Message.ROOM_NOT_FOUND);
        }
    }

    public void checkIfCheckInAndCheckOutIsNullOrInvalid(LocalDate checkIn, LocalDate checkOut) {
        if(checkIn == null || checkOut == null){
            throw new ServiceException(StatusCode.CHECK_IN_OR_CHECK_OUT_NULL_EXCEPTION,Message.CHECK_IN_OR_CHECK_OUT_NULL_EXCEPTION);
        }
        else if(LocalDate.now().isBefore(checkIn)){
            throw new ServiceException(StatusCode.CHECK_IN_IS_NOT_BECOME_BEFORE_FROM_NOW,Message.CHECK_IN_IS_NOT_BECOME_BEFORE_FROM_NOW);
        }
    }
}
