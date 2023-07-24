package com.company.hrs.service.concretes;

import com.company.hrs.entities.*;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.HotelRepository;
import com.company.hrs.repository.HotelServiceRepository;
import com.company.hrs.service.abstracts.CityService;
import com.company.hrs.service.abstracts.HotelService;
import com.company.hrs.service.abstracts.HotelServiceService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.service.dtos.hotel.requests.SearchHotelRequest;
import com.company.hrs.service.dtos.hotel.response.GetHomeHotelsResponse;
import com.company.hrs.service.dtos.hotel.response.GetByEmployeeIdResponse;
import com.company.hrs.service.dtos.hotel.response.GetHotelDetailsResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.service.rules.HotelServiceRules;
import com.company.hrs.utils.exceptions.ServiceException;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapperService modelMapperService;
    private final CityService cityService;
    private final HotelServiceRules hotelServiceRules;
    private final HotelServiceRepository hotelServiceRepository;
    private final HotelServiceService hotelServiceService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result create(CreateHotelRequest request) {
        Contact contact = new Contact();
        contact.setPhone(request.getPhone());

        Address address = new Address();
        address.setCity(modelMapperService.forRequest().map(cityService.getById(request.getCityId()).getData(),City.class));
        address.setAddressLine(request.getAddressLine());

        Hotel hotel = modelMapperService.forRequest().map(request,Hotel.class);
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
        request.getServiceIds().stream().forEach(id->{
            com.company.hrs.entities.HotelService hotelService = new com.company.hrs.entities.HotelService();
            hotelService.setHotel(hotel);
            com.company.hrs.entities.Service service = new com.company.hrs.entities.Service();
            service.setId(id);
            hotelService.setService(service);
            hotelServiceRepository.save(hotelService);
        });
        hotelRepository.save(hotel);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetHomeHotelsResponse>> getHomeHotels(SearchHotelRequest searchHotelRequest) {
        List<Hotel> hotels = hotelRepository.findAllByActive(Status.ACTIVE);
        if (searchHotelRequest.getCheckIn()!=null && searchHotelRequest.getCheckOut()!=null){
            hotels = hotelRepository.getHotelsByCheckInAndCheckOut(searchHotelRequest.getCheckIn(),searchHotelRequest.getCheckOut());
        }
        if(searchHotelRequest.getCityId()!=null){
            List<Hotel> hotelList = new ArrayList<>();
            hotels.stream().forEach(hotel -> {
                if(hotel.getAddress().getCity().getId()==searchHotelRequest.getCityId())
                    hotelList.add(hotel);
            });
            hotels = hotelList;
        }
        if(searchHotelRequest.getRoomCount()!=null){
            Set<Hotel> hotelSet = new HashSet<>();
            hotels.stream().forEach(hotel -> {
                hotel.getRooms().stream().forEach(room -> {
                    if(room.getRoomCount() == searchHotelRequest.getRoomCount())
                        hotelSet.add(hotel);
                });
            });
            hotels = hotelSet.stream().toList();
        }
        if(searchHotelRequest.getAdultCount()!=null){
            Set<Hotel> hotelSet = new HashSet<>();
            hotels.stream().forEach(hotel -> {
                hotel.getRooms().stream().forEach(room -> {
                    if(room.getAdultCount() == searchHotelRequest.getAdultCount())
                        hotelSet.add(hotel);
                });
            });
            hotels = hotelSet.stream().toList();
        }
        if(searchHotelRequest.getChildreenCount()!=null){
            Set<Hotel> hotelSet = new HashSet<>();
            hotels.stream().forEach(hotel -> {
                hotel.getRooms().stream().forEach(room -> {
                    if(room.getChildreenCount() == searchHotelRequest.getChildreenCount())
                        hotelSet.add(hotel);
                });
            });
            hotels = hotelSet.stream().toList();
        }
        hotelServiceRules.checkIfHotelsIsNullOrEmpty(hotels);
        List<GetHomeHotelsResponse> homeHotelResponses = hotels.stream().map(hotel -> modelMapperService.forResponse().map(hotel, GetHomeHotelsResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetHomeHotelsResponse>>(homeHotelResponses);
    }

    @Override
    public DataResult<GetHotelDetailsResponse> getHotelDetails(Long id) {
        Hotel hotel = hotelRepository.findByIdAndActive(id,Status.ACTIVE);
        GetHotelDetailsResponse hotelDetailsResponse = modelMapperService.forResponse().map(hotel,GetHotelDetailsResponse.class);
        hotelDetailsResponse.setServices(hotelServiceService.getAllServiceByHotel(modelMapperService.forRequest().map(hotel,Hotel.class)));
        return new SuccessDataResult<GetHotelDetailsResponse>(hotelDetailsResponse);
    }

    @Override
    public DataResult<GetByEmployeeIdResponse> getByEmployeeId(Long id) {
        Hotel hotel = hotelRepository.findByEmployeeId(id,Status.ACTIVE);
        hotelServiceRules.checkIfHotelIsNull(hotel);
        return new SuccessDataResult<GetByEmployeeIdResponse>(modelMapperService.forResponse().map(hotel,GetByEmployeeIdResponse.class));
    }



    @Transactional(rollbackFor = Exception.class)
    public String saveImage(MultipartFile image){
        Path fileStorageLocation = Paths.get("D:\\Projects\\HRS_Frontend\\src\\assets\\img");
        String originalFileName = image.getOriginalFilename();
        try (InputStream inputStream = image.getInputStream()) {
            hotelServiceRules.checkIfFileNameInvalid(originalFileName);
            Path targetLocation = fileStorageLocation.resolve(originalFileName);
            Files.copy(inputStream,targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return originalFileName;
        } catch (IOException e) {
            throw new ServiceException(StatusCode.IO_EXCEPTION, Message.IO_EXCEPTION);
        }
    }
}
