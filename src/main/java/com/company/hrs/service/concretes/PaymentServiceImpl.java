package com.company.hrs.service.concretes;

import com.company.hrs.entities.Contact;
import com.company.hrs.entities.Payment;
import com.company.hrs.entities.Person;
import com.company.hrs.enums.BookingStatus;
import com.company.hrs.enums.PaymentStatus;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.PaymentRepository;
import com.company.hrs.repository.PersonRepository;
import com.company.hrs.service.abstracts.AccountService;
import com.company.hrs.service.abstracts.PaymentService;
import com.company.hrs.service.abstracts.PersonService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.account.requests.CustomerRegisterForHotelOrBroker;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForBrokerRequest;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForCustomerRequest;
import com.company.hrs.service.dtos.payment.requests.CreatePaymentForHotelRequest;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;
import com.company.hrs.service.result.DataResult;
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
    private final PersonRepository personRepository;
    private final PersonService personService;
    private final AccountService accountService;
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
        Person person = personRepository.getPersonByEmailAndActive(createPaymentForHotelRequest.getBooking().getCustomer().getEmail(), Status.ACTIVE);
        if(person == null){
            CustomerRegisterForHotelOrBroker registerRequest = modelMapperService.forRequest().map(createPaymentForHotelRequest.getBooking().getCustomer(),CustomerRegisterForHotelOrBroker.class);
            Result result = accountService.register(registerRequest);

            if (result.getCode() == 200){
                payment.getBooking().setOrderer(personRepository.getPersonByEmailAndActive(registerRequest.getEmail(), Status.ACTIVE));
            }
        }
        else{
            payment.getBooking().setOrderer(person);
        }
        paymentRepository.save(payment);
        return new SuccessResult();
    }

    @Override
    public Result createPaymentForBroker(CreatePaymentForBrokerRequest request) {
        Payment payment = modelMapperService.forRequest().map(request, Payment.class);
        if(request.getAmount().equals(request.getBooking().getPricePerNight()))
            payment.setPaymentStatus(PaymentStatus.COMPLETED);
        else
            payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.getBooking().setBookingStatus(BookingStatus.CONFIRMED);
        payment.getBooking().setReservationNumber(UUID.randomUUID().toString());
        Person person = personRepository.getPersonByEmailAndActive(request.getBooking().getCustomer().getEmail(), Status.ACTIVE);
        if(person == null){
            CustomerRegisterForHotelOrBroker registerRequest = modelMapperService.forRequest().map(request.getBooking().getCustomer(),CustomerRegisterForHotelOrBroker.class);
            Result result = accountService.register(registerRequest);

            if (result.getCode() == 200){
                payment.getBooking().setOrderer(personRepository.getPersonByEmailAndActive(registerRequest.getEmail(), Status.ACTIVE));
            }
        }
        else{
            payment.getBooking().setOrderer(person);
        }
        paymentRepository.save(payment);
        return new SuccessResult();
    }
}
