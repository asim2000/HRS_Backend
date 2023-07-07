package com.company.hrs.service.concretes;

import com.company.hrs.repository.HotelRepository;
import com.company.hrs.service.abstracts.HotelService;
import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    @Override
    public void create(CreateHotelRequest request) {

    }
}
