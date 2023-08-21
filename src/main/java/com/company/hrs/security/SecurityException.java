package com.company.hrs.security;

import lombok.Data;

@Data
public class SecurityException extends RuntimeException{
    private Integer code;
    public SecurityException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
