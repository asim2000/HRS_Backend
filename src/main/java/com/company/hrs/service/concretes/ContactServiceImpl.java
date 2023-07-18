package com.company.hrs.service.concretes;

import com.company.hrs.entities.Contact;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.ContactRepository;
import com.company.hrs.service.abstracts.ContactService;
import com.company.hrs.service.dtos.contact.requests.CreateContactRequest;
import com.company.hrs.service.dtos.contact.responses.CreatedContactResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<CreatedContactResponse> create(CreateContactRequest request) {
        Contact contact = contactRepository.save(modelMapperService.forRequest().map(request,Contact.class));
        CreatedContactResponse response = modelMapperService.forResponse().map(contact,CreatedContactResponse.class);
        return new SuccessDataResult<CreatedContactResponse>(response);
    }

    @Override
    public DataResult<Boolean> existsContactByEmail(String email) {
        Boolean response = contactRepository.existsContactByEmailAndActive(email, Status.ACTIVE);
        return new SuccessDataResult<Boolean>(response);
    }


}
