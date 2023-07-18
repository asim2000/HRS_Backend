package com.company.hrs.service.result;

import com.company.hrs.service.constant.Message;
import com.company.hrs.service.constant.StatusCode;

public class SuccessResult extends Result{
    public SuccessResult(){
        super(StatusCode.SUCCESS, Message.OK);
    }
}
