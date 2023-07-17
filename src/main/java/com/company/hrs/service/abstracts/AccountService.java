package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.account.requests.LoginRequest;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

public interface AccountService {
    Result register(RegisterRequest registerRequest);
    DataResult<LoginPersonResponse> login(LoginRequest loginRequest);
}
