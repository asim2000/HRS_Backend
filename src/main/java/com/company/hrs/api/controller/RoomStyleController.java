package com.company.hrs.api.controller;

import com.company.hrs.enums.RoomStyle;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("roomstyle")
@CrossOrigin
public class RoomStyleController {
    @GetMapping("getall")
    public DataResult<List<RoomStyle>> getAll(){
        return new SuccessDataResult<List<RoomStyle>>(List.of(RoomStyle.values()));
    }
}
