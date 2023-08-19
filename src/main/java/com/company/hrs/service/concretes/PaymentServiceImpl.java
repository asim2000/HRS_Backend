package com.company.hrs.service.concretes;

import com.company.hrs.entities.Payment;
import com.company.hrs.enums.BookingStatus;
import com.company.hrs.enums.PaymentStatus;
import com.company.hrs.repository.PaymentRepository;
import com.company.hrs.service.abstracts.PaymentService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForCustomerRequest;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForHotelRequest;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.utils.exceptions.ServiceException;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapperService modelMapperService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result createPaymentForCustomer(CreatePaymentForCustomerRequest createPaymentForCustomerRequest) {
        Long daysBetween = ChronoUnit.DAYS.between(createPaymentForCustomerRequest.getBooking().getCheckIn(), createPaymentForCustomerRequest.getBooking().getCheckOut()) + 1;
        if(createPaymentForCustomerRequest.getBooking().getPricePerNight()*daysBetween/5>createPaymentForCustomerRequest.getAmount()){
            throw new ServiceException(StatusCode.INVALID_AMOUNT_EXCEPTION, Message.INVALID_AMOUNT_EXCEPTION);
        }
        //Odenis olunacaq
        Payment payment = modelMapperService.forRequest().map(createPaymentForCustomerRequest, Payment.class);
        if(createPaymentForCustomerRequest.getAmount().equals(createPaymentForCustomerRequest.getBooking().getPricePerNight()))
            payment.setPaymentStatus(PaymentStatus.COMPLETED);
        else
            payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.getBooking().setBookingStatus(BookingStatus.CONFIRMED);
        payment.getBooking().setReservationNumber(UUID.randomUUID().toString());
        if(!createPaymentForCustomerRequest.getIsSaveCard())
            payment.setCreditCard(null);
        paymentRepository.save(payment);
        return new SuccessResult();
    }

    @Override
    public Result createPaymentForHotel(CreatePaymentForHotelRequest createPaymentForHotelRequest) {
        Payment payment = modelMapperService.forRequest().map(createPaymentForHotelRequest, Payment.class);
        if(createPaymentForHotelRequest.getAmount().equals(createPaymentForHotelRequest.getBooking().getPricePerNight()))
            payment.setPaymentStatus(PaymentStatus.COMPLETED);
        else
            payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.getBooking().setBookingStatus(BookingStatus.CONFIRMED);
        payment.getBooking().setReservationNumber(UUID.randomUUID().toString());
        paymentRepository.save(payment);
        return new SuccessResult();
    }
}
