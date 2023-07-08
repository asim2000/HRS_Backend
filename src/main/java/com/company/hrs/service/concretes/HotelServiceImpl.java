package com.company.hrs.service.concretes;

import com.company.hrs.entities.*;
import com.company.hrs.repository.HotelRepository;
import com.company.hrs.service.abstracts.CityService;
import com.company.hrs.service.abstracts.HotelService;
import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapperService modelMapperService;
    private final CityService cityService;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void create(CreateHotelRequest request) {
        Contact contact = new Contact();
        contact.setPhone(request.getPhone());

        Address address = new Address();
        address.setCity(modelMapperService.forRequest().map(cityService.getById(request.getCityId()),City.class));
        address.setAddressLine(request.getAddressLine());

        Hotel hotel = new Hotel();
        hotel.setContact(contact);
        hotel.setAddress(address);
        hotel.setName(request.getName());
        hotel.setDescription(request.getDescription());
        hotel.setImages(Arrays.stream(request.getImages()).map(image->{
            HotelImage hotelImage = new HotelImage();
            try {
                hotelImage.setImage(image.getBytes());
                return hotelImage;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList()));
        hotel.setServices(request.getServiceIds().stream().map(id->{
            com.company.hrs.entities.Service service = new com.company.hrs.entities.Service();
            service.setId(id);
            return service;
        }).collect(Collectors.toList()));
        hotelRepository.save(hotel);
    }
}
