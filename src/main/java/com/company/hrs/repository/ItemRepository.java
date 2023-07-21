package com.company.hrs.repository;

import com.company.hrs.entities.Item;
import com.company.hrs.enums.Status;
import com.company.hrs.service.dtos.item.responses.GetAllItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findAllByActive(Status active);
}
