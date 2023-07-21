package com.company.hrs.service.concretes;

import com.company.hrs.entities.Item;
import com.company.hrs.enums.Status;
import com.company.hrs.repository.ItemRepository;
import com.company.hrs.service.abstracts.ItemService;
import com.company.hrs.service.dtos.item.requests.CreateItemRequest;
import com.company.hrs.service.dtos.item.responses.GetAllItemResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessDataResult;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapperService modelMapperService;
    @Override
    public Result create(CreateItemRequest createItemRequest) {
        itemRepository.save(modelMapperService.forRequest().map(createItemRequest, Item.class));
        return new SuccessResult();
    }

    @Override
    public DataResult<List<GetAllItemResponse>> getAll() {
        List<Item> items = itemRepository.findAllByActive(Status.ACTIVE);
        List<GetAllItemResponse> getAllItemResponses = items.stream().map(item -> modelMapperService.forResponse().map(item, GetAllItemResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllItemResponse>>(getAllItemResponses);
    }
}
