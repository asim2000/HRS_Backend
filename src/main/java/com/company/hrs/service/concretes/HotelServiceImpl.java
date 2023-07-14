package com.company.hrs.service.concretes;

import com.company.hrs.entities.*;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.HotelRepository;
import com.company.hrs.service.abstracts.CityService;
import com.company.hrs.service.abstracts.HotelService;
import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.service.dtos.hotel.response.GetAllHomeHotelResponse;
import com.company.hrs.service.rules.HotelServiceRules;
import com.company.hrs.utils.exceptions.ServiceException;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    private final HotelServiceRules hotelServiceRules;
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
                hotelImage.setPath(saveImage(image));
                hotelImage.setHotel(hotel);
                return hotelImage;
        }).collect(Collectors.toList()));
        hotel.setServices(request.getServiceIds().stream().map(id->{
            com.company.hrs.entities.Service service = new com.company.hrs.entities.Service();
            service.setId(id);
            //service.getHotels().add(hotel);
            return service;
        }).collect(Collectors.toList()));
        //hotel.getContact().setHotel(hotel);
        //hotel.getAddress().setHotel(hotel);
        hotelRepository.save(hotel);
    }

    @Override
    public List<GetAllHomeHotelResponse> getAllHomeHotels() {
        List<Hotel> hotels = hotelRepository.findAllByActive(Status.ACTIVE);
        hotelServiceRules.checkIfHotelListIsNull(hotels);
        return hotels.stream().map(hotel -> modelMapperService.forResponse().map(hotel,GetAllHomeHotelResponse.class)).collect(Collectors.toList());
    }
    private String saveImage(MultipartFile image){
        Path fileStorageLocation = Paths.get("D:\\Projects\\HRS_Frontend\\src\\assets\\img");
        String originalFileName = image.getOriginalFilename();
        try (InputStream inputStream = image.getInputStream()) {
            if(originalFileName.contains("..")){
                throw new ServiceException("File name contains invalid path: "+originalFileName);
            }
            Path targetLocation = fileStorageLocation.resolve(originalFileName);
            Files.copy(inputStream,targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return originalFileName;
        } catch (IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
