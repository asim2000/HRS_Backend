package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.account.requests.LoginRequest;
import com.company.hrs.service.dtos.account.requests.RegisterRequest;
import com.company.hrs.service.dtos.person.responses.LoginPersonResponse;

public interface AccountService {
    void register(RegisterRequest registerRequest);
    LoginPersonResponse login(LoginRequest loginRequest);
}
