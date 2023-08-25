package com.company.hrs.service.concretes;

import com.company.hrs.entities.Person;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.PersonRepository;
import com.company.hrs.service.abstracts.PersonService;
import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.dtos.person.requests.CreatePersonRequest;
import com.company.hrs.service.dtos.person.responses.CreatedPersonResponse;
import com.company.hrs.service.dtos.person.responses.GetPersonDetailsResponse;
import com.company.hrs.service.dtos.person.responses.GetPersonPasswordByEmailResponse;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.rules.PersonServiceRules;
import com.company.hrs.utils.exceptions.ServiceException;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private ModelMapperService modelMapperService;
    private PersonServiceRules personServiceRules;
    @Override
    public DataResult<CreatedPersonResponse> create(CreatePersonRequest createPersonRequest) {
        Person p = modelMapperService.forRequest().map(createPersonRequest,Person.class);
        if(createPersonRequest.getImage()!=null)
          p.setImage(saveImage(createPersonRequest.getImage()));
        else
            p.setImage("avatar.jpg");
        Person person = personRepository.save(p);
        CreatedPersonResponse response = modelMapperService.forResponse().map(person,CreatedPersonResponse.class);
        return new SuccessDataResult<CreatedPersonResponse>(response);
    }
    public String saveImage(MultipartFile image){
        Path fileStorageLocation = Paths.get("D:\\Projects\\HRS_Frontend\\src\\assets\\img");
        String originalFileName = image.getOriginalFilename();
        try (InputStream inputStream = image.getInputStream()) {
            personServiceRules.checkIfFileNameInvalid(originalFileName);
            Path targetLocation = fileStorageLocation.resolve(originalFileName);
            Files.copy(inputStream,targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return originalFileName;
        } catch (IOException e) {
            throw new ServiceException(StatusCode.IO_EXCEPTION, Message.IO_EXCEPTION);
        }
    }

    @Override
    public DataResult<Boolean> existsPersonByEmailAndPassword(String email, String password) {
        Boolean response = personRepository.existsPersonByEmailAndPasswordAndActive(email,password, Status.ACTIVE);
        return new SuccessDataResult<Boolean>(response);
    }

    @Override
    public DataResult<LoginPersonResponse> getPersonByEmail(String email) {
        LoginPersonResponse response = modelMapperService.forResponse().map(personRepository.getPersonByEmailAndActive(email,Status.ACTIVE),LoginPersonResponse.class);
        return new SuccessDataResult<LoginPersonResponse>(response);
    }

    @Override
    public DataResult<GetPersonPasswordByEmailResponse> getPersonPasswordByEmail(String email) {
        return new SuccessDataResult<>(modelMapperService.forResponse().map(personRepository.getPersonPasswordByEmail(email),GetPersonPasswordByEmailResponse.class));
    }

    @Override
    public DataResult<GetPersonDetailsResponse> getById(Long id) {
        return new SuccessDataResult<>(modelMapperService.forResponse().map(personRepository.getById(id),GetPersonDetailsResponse.class));
    }
}
