package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.account.requests.RegisterRequest;

public interface AccountService {
    void register(RegisterRequest registerRequest);

}
