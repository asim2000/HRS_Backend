package com.company.hrs.service.concretes;

import com.company.hrs.entities.Booking;
import com.company.hrs.enums.BookingStatus;
import com.company.hrs.repository.BookingRepository;
import com.company.hrs.service.abstracts.BookingService;
import com.company.hrs.service.dtos.booking.requests.CreateBookingRequest;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public Result book(CreateBookingRequest createBookRequest) {
        Booking booking = modelMapperService.forRequest().map(createBookRequest, Booking.class);
        booking.setReservationNumber(UUID.randomUUID().toString());
        booking.setBookingStatus(BookingStatus.PENDING);
        bookingRepository.save(booking);
        return new SuccessResult();
    }
}
