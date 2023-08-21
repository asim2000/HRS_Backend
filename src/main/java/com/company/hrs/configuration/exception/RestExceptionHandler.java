package com.company.hrs.configuration.exception;

import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.result.Result;
import com.company.hrs.utils.exceptions.ServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException serviceException){
        return new Result(serviceException.getCode(),serviceException.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotalidException(MethodArgumentNotValidException methodArgumentNotValidException){
        StringBuilder message = new StringBuilder();
        for(FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            message.append(fieldError.getField() + " : " + fieldError.getDefaultMessage());
            message.append('\n');
        }
        return new Result(StatusCode.ValidationException,message.toString());
    }
    @ExceptionHandler(BadCredentialsException.class)
    public Result handleAuthenticateException(BadCredentialsException ex){
        return new Result(StatusCode.USERNAME_OR_PASSWORD_INVALID,Message.USERNAME_OR_PASSWORD_INVALID);
    }
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception exception){
        return new Result(StatusCode.INTERNAL_EXCEPTION,Message.INTERNAL_EXCEPTION);
    }
}
