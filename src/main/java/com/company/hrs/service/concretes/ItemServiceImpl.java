package com.company.hrs.service.concretes;

import com.company.hrs.entities.Item;
import com.company.hrs.repository.ItemRepository;
import com.company.hrs.service.abstracts.ItemService;
import com.company.hrs.service.dtos.item.requests.CreateItemRequest;
import com.company.hrs.service.result.Result;
import com.company.hrs.service.result.SuccessResult;
import com.company.hrs.utils.mappers.ModelMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
