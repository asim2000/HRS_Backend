package com.company.hrs.service.concretes;

import com.company.hrs.entities.*;
import com.company.hrs.enums.PerCent;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.EmployeeRepository;
import com.company.hrs.repository.HotelRepository;
import com.company.hrs.repository.HotelServiceRepository;
import com.company.hrs.service.abstracts.*;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.hotel.requests.CreateHotelRequest;
import com.company.hrs.service.dtos.hotel.requests.SearchHotelRequest;
import com.company.hrs.service.dtos.hotel.response.*;
import com.company.hrs.service.dtos.report.requests.PostDateRangeRequest;
import com.company.hrs.service.dtos.room.responses.GetUnReservedRoomsResponse;
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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements com.company.hrs.service.abstracts.HotelService {
    private final HotelRepository hotelRepository;
    private final ModelMapperService modelMapperService;
    private final CityService cityService;
    private final HotelServiceRules hotelServiceRules;
    private final HotelServiceRepository hotelServiceRepository;
    private final HotelServiceService hotelServiceService;
    private final RoomService roomService;
    private final EmployeeRepository employeeRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Result create(CreateHotelRequest request) {
        Contact contact = new Contact();
        contact.setPhone(request.getPhone());

        Address address = new Address();
        address.setCity(modelMapperService.forRequest().map(cityService.getById(request.getCityId()).getData(),City.class));
        address.setAddressLine(request.getAddressLine());
        Employee employee = employeeRepository.findByPersonId(request.getPersonId());
        Hotel hotel = modelMapperService.forRequest().map(request,Hotel.class);
        hotel.setContact(contact);
        hotel.setAddress(address);
        hotel.setName(request.getName());
        hotel.setDescription(request.getDescription());
        hotel.setImages(Arrays.stream(request.getImages()).map(image->{
            HotelImage hotelImage = new HotelImage();
                hotelImage.setName(saveImage(image));
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
        Hotel createdHotel = hotelRepository.save(hotel);
        employee.setHotel(createdHotel);
        employeeRepository.save(employee);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetHomeHotelsResponse>> getHomeHotels(SearchHotelRequest searchHotelRequest) {
        List<Hotel> hotels = new ArrayList<>();
        hotelServiceRules.checkIfCheckInOrCheckOutIsNullOrInvalid(searchHotelRequest.getCheckIn(),searchHotelRequest.getCheckOut());
        DataResult<List<GetUnReservedRoomsResponse>> dataResult = roomService.getUnReservedRooms(searchHotelRequest.getCheckIn(),searchHotelRequest.getCheckOut());
        List<Room> rooms = dataResult.getData().stream().map(data->modelMapperService.forRequest().map(data,Room.class)).collect(Collectors.toList());

        if(searchHotelRequest.getRoomCount()!=null){
            List<Room> roomList = new ArrayList<>();
            rooms.stream().forEach(room ->  {
                if(room.getRoomCount()==searchHotelRequest.getRoomCount())
                    roomList.add(room);
            });
            rooms = roomList;
        }
        if(searchHotelRequest.getAdultCount()!=null){
            List<Room> roomList = new ArrayList<>();
            rooms.stream().forEach(room ->  {
                if(room.getAdultCount()>=searchHotelRequest.getAdultCount())
                    roomList.add(room);
            });
            rooms = roomList;
        }
        if(searchHotelRequest.getChildreenCount()!=null){
            List<Room> roomList = new ArrayList<>();
            rooms.stream().forEach(room ->  {
                if(room.getChildreenCount()>=searchHotelRequest.getChildreenCount())
                    roomList.add(room);
            });
            rooms = roomList;
        }
        hotels = rooms.stream().map(room -> room.getHotel()).collect(Collectors.toList());

        if(searchHotelRequest.getCityId()!=null){
            List<Hotel> hotelList = new ArrayList<>();
            hotels.stream().forEach(hotel -> {
                if(hotel.getAddress().getCity().getId() == searchHotelRequest.getCityId())
                    hotelList.add(hotel);
            });
            hotels = hotelList;
        }
        hotelServiceRules.checkIfHotelsIsNullOrEmpty(hotels);
        List<GetHomeHotelsResponse> homeHotelResponses = hotels.stream().map(hotel -> {
            GetHomeHotelsResponse homeHotelsResponse = modelMapperService.forResponse().map(hotel, GetHomeHotelsResponse.class);
            homeHotelsResponse.setMinimumPrice(hotelRepository.getMinimumPriceByHotelId(hotel.getId()));
            return homeHotelsResponse;
        }).collect(Collectors.toList());
        return new SuccessDataResult<List<GetHomeHotelsResponse>>(homeHotelResponses);
    }

    @Override
    public DataResult<GetHotelDetailsResponse> getHotelDetails(Long id) {
        Hotel hotel = hotelRepository.findByIdAndActive(id,Status.ACTIVE);
        GetHotelDetailsResponse hotelDetailsResponse = modelMapperService.forResponse().map(hotel,GetHotelDetailsResponse.class);
        hotelDetailsResponse.setServices(hotelServiceService.getAllServiceByHotel(modelMapperService.forRequest().map(hotel,Hotel.class)));
        hotelDetailsResponse.setMinimumPrice(hotelRepository.getMinimumPriceByHotelId(id));
        return new SuccessDataResult<GetHotelDetailsResponse>(hotelDetailsResponse);
    }

    @Override
    public DataResult<GetByEmployeeIdResponse> getByEmployeeId(Long id) {
        Hotel hotel = hotelRepository.findByPersonId(id,Status.ACTIVE);
        hotelServiceRules.checkIfHotelIsNull(hotel);
        return new SuccessDataResult<>(modelMapperService.forResponse().map(hotel,GetByEmployeeIdResponse.class));
    }

    @Override
    public DataResult<Boolean> checkIfExistsRoom(Long hotelId) {
        Hotel hotel = hotelRepository.findByIdAndActive(hotelId,Status.ACTIVE);
        if(hotel.getRooms() == null || hotel.getRooms().isEmpty())
            return new SuccessDataResult<>(false);
        return new SuccessDataResult<>(true);
    }

    @Override
    public DataResult<GetReportResponse> getReportByHotel(Long id, PostDateRangeRequest request) {
        return new SuccessDataResult<>(new GetReportResponse(hotelRepository.getReportOfHotel(id,request.getStartDate(),request.getEndDate()),hotelRepository.getReportOfOther(id,PerCent.HOTEL.value,request.getStartDate(),request.getEndDate())));
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
