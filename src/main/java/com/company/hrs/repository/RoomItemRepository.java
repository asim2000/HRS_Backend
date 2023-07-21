package com.company.hrs.repository;

import com.company.hrs.entities.RoomItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomItemRepository extends JpaRepository<RoomItem,Long> {
}
