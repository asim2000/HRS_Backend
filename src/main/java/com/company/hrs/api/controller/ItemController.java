package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.ItemService;
import com.company.hrs.service.dtos.item.requests.CreateItemRequest;
import com.company.hrs.service.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping("create")
    public Result create(CreateItemRequest createItemRequest){
        return itemService.create(createItemRequest);
    }
}
