package com.company.hrs.configuration.exception;

import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;
import com.company.hrs.service.result.Result;
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
    public Result handleServiceException(ServiceException serviceException){
        return new Result(serviceException.getCode(),serviceException.getMessage());
    }
    @ExceptionHandler
    public Result handleServiceException(MethodArgumentNotValidException methodArgumentNotValidException){
        StringBuilder message = new StringBuilder();
        for(FieldError fieldError:methodArgumentNotValidException.getBindingResult().getFieldErrors()){
            message.append(fieldError.getField() + " : " + fieldError.getDefaultMessage());
            message.append('\n');
        }
        return new Result(StatusCode.ValidationException,message.toString());
    }
//    @ExceptionHandler
//    public Result handleServiceException(Exception exception){
//        return new Result(StatusCode.INTERNAL_EXCEPTION,Message.INTERNAL_EXCEPTION);
//    }
}
