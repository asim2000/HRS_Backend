package com.company.hrs.service.concretes;

import com.company.hrs.entities.Hotel;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.HotelServiceRepository;
import com.company.hrs.service.abstracts.HotelService;
import com.company.hrs.service.abstracts.HotelServiceService;
import com.company.hrs.service.dtos.hotelService.responses.GetAllServiceByHotelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceServiceImpl implements HotelServiceService {
    private final HotelServiceRepository hotelServiceRepository;
    @Override
    public List<GetAllServiceByHotelResponse> getAllServiceByHotel(Hotel hotel) {
        List<GetAllServiceByHotelResponse> response = new ArrayList<>();
        response.addAll(hotelServiceRepository.findAllByHotelAndActive(hotel, Status.ACTIVE)
                .stream().map(hotelService -> {
                    GetAllServiceByHotelResponse getAllServiceByHotelResponse = new GetAllServiceByHotelResponse();
                    getAllServiceByHotelResponse.setId(hotelService.getService().getId());
                    getAllServiceByHotelResponse.setName(hotelService.getService().getName());
                    return getAllServiceByHotelResponse;
                }).collect(Collectors.toList()));
        return response;
    }
}
