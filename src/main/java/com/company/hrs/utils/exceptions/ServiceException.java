package com.company.hrs.utils.exceptions;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException{
    private Integer code;
    public ServiceException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
