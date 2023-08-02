package com.company.hrs.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthorizationException extends RuntimeException{
    private Integer code;
    public AuthorizationException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
