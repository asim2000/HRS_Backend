package com.company.hrs.service.concretes;

import com.company.hrs.entities.Booking;
import com.company.hrs.repository.BookingRepository;
import com.company.hrs.service.abstracts.BookingService;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByHotelIdResponse;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByOrderedIdResponse;
import com.company.hrs.service.dtos.booking.responses.GetAllBookingsByOrdererIdResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public DataResult<List<GetAllBookingsByOrdererIdResponse>> getAllByPersonId(Long id) {
        List<Booking> bookings = bookingRepository.getAllByPersonId(id);
        return new SuccessDataResult<List<GetAllBookingsByOrdererIdResponse>>(bookings.stream().map(booking -> modelMapperService.forResponse().map(booking, GetAllBookingsByOrdererIdResponse.class)).collect(Collectors.toList()));
    }

    @Override
    public DataResult<List<GetAllBookingsByHotelIdResponse>> getAllBookingsByHotelId(Long id) {
        List<Booking> bookings = bookingRepository.getAllBookingsByHotelId(id);
        return new SuccessDataResult<>(bookings.stream().map(booking -> modelMapperService.forResponse().map(booking, GetAllBookingsByHotelIdResponse.class)).collect(Collectors.toList()));
    }

    @Override
    public DataResult<List<GetAllBookingsByOrderedIdResponse>> getAllByOrderedId(Long id) {
        List<Booking> bookings = bookingRepository.getAllByOrderedId(id);
        return new SuccessDataResult<List<GetAllBookingsByOrderedIdResponse>>(bookings.stream().map(booking -> modelMapperService.forResponse().map(booking, GetAllBookingsByOrderedIdResponse.class)).collect(Collectors.toList()));
    }
}
