package com.company.hrs.service.result;

import lombok.Data;

@Data
public class DataResult<T> extends Result{
    private T data;
    public DataResult(T data,Integer code,String message){
        super(code,message);
        this.data = data;
    }
}
