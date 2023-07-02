package com.company.hrs.service.concretes;

import com.company.hrs.entities.Contact;
import com.company.hrs.repository.ContactRepository;
import com.company.hrs.service.abstracts.ContactService;
import com.company.hrs.service.dtos.contact.requests.CreateContactRequest;
import com.company.hrs.service.dtos.contact.responses.CreatedContactResponse;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedContactResponse create(CreateContactRequest request) {
        Contact contact = contactRepository.save(modelMapperService.forRequest().map(request,Contact.class));
        return modelMapperService.forResponse().map(contact,CreatedContactResponse.class);
    }

    @Override
    public boolean existsContactByByEmail(String email) {
        return contactRepository.existsContactByEmail(email);
    }
}
