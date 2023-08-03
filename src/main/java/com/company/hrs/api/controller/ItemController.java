package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.ItemService;
import com.company.hrs.service.dtos.item.requests.CreateItemRequest;
import com.company.hrs.service.dtos.item.responses.GetAllItemResponse;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping()
    public Result create(@RequestBody @Valid CreateItemRequest createItemRequest){
        return itemService.create(createItemRequest);
    }
    @GetMapping()
    public DataResult<List<GetAllItemResponse>> getAll(){
        return itemService.getAll();
    }
}
