package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.item.requests.CreateItemRequest;
import com.company.hrs.service.dtos.item.responses.GetAllItemResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;

import java.util.List;

public interface ItemService {
    Result create(CreateItemRequest createItemRequest);
    DataResult<List<GetAllItemResponse>> getAll();
    DataResult<List<GetAllItemResponse>> getAllByRoomId(Long id);
}
