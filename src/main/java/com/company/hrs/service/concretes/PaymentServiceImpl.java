package com.company.hrs.service.concretes;

import com.company.hrs.entities.Payment;
import com.company.hrs.enums.BookingStatus;
import com.company.hrs.enums.PaymentStatus;
import com.company.hrs.repository.PaymentRepository;
import com.company.hrs.service.abstracts.PaymentService;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentRequest;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ModelMapperService modelMapperService;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result create(CreatePaymentRequest createPaymentRequest) {
        //Odenis olunacaq
        Payment payment = modelMapperService.forRequest().map(createPaymentRequest, Payment.class);
        if(createPaymentRequest.getAmount() == createPaymentRequest.getBooking().getPricePerNight())
            payment.setPaymentStatus(PaymentStatus.COMPLETED);
        else
            payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.getBooking().setBookingStatus(BookingStatus.CONFIRMED);
        payment.getBooking().setReservationNumber(UUID.randomUUID().toString());
        if(!createPaymentRequest.getIsSaveCard())
            payment.setCreditCard(null);
        paymentRepository.save(payment);
        return new SuccessResult();
    }
}
