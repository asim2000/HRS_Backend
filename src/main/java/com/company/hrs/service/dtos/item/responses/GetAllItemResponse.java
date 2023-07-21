package com.company.hrs.service.dtos.item.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllItemResponse {
    private Long id;
    private String name;
}
