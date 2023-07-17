package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.item.requests.CreateItemRequest;
import com.company.hrs.service.result.Result;

public interface ItemService {
    Result create(CreateItemRequest createItemRequest);
}
