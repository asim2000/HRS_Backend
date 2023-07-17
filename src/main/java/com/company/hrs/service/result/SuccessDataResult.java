package com.company.hrs.service.result;

import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(T data){
        super(data, StatusCode.OK, Message.OK);
    }

}
