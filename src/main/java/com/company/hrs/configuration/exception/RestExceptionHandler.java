package com.company.hrs.configuration.exception;

import com.company.hrs.utils.exceptions.ProblemDetails;
import com.company.hrs.utils.exceptions.ServiceException;
import com.company.hrs.utils.exceptions.ValidationProblemDetails;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ProblemDetails handleServiceException(ServiceException serviceException){
        return new ProblemDetails(serviceException.getMessage());
    }
    @ExceptionHandler
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleServiceException(MethodArgumentNotValidException methodArgumentNotValidException){
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails(new HashMap<>());
        for(FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return validationProblemDetails;
    }
//    @ExceptionHandler
//    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
//    public ProblemDetails handleServiceException(Exception exception){
//        return new ProblemDetails(exception.getMessage());
//    }
}
