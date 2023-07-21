package com.company.hrs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room_item")
public class RoomItem extends BaseEntity{
    @ManyToOne()
    @JoinColumn(name = "room_id",referencedColumnName = "id")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    private Item item;
}
