package com.company.hrs.entities;

import com.company.hrs.enums.RoomStatus;
import com.company.hrs.enums.RoomStyle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room extends BaseEntity{

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(name = "room_number")
    private Long roomNumber;

    @NotNull
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull
    @Column(name = "floor", nullable = false)
    private Long floor;

    @NotNull
    @Column(name = "max_people_count", nullable = false)
    private byte maxPeopleCount;

    @Size(max = 50)
    @NotNull
    @Column(name = "roomStatus", nullable = false, length = 50)
    private RoomStatus roomStatus;

    @NotNull
    @Column(name = "pair_bed_count", nullable = false)
    private Long pairBedCount;

    @NotNull
    @Column(name = "single_bed_count", nullable = false)
    private Long singleBedCount;

    @Column(name = "is_pet")
    private boolean isPet;

    @NotNull
    @Column(name = "room_count", nullable = false)
    private Long roomCount;

    @NotNull
    @Column(name = "shower_count", nullable = false)
    private Long showerCount;

    @Size(max = 2000)
    @Column(name = "description", length = 2000)
    private String description;

    @Size(max = 50)
    @NotNull
    @Column(name = "room_style", nullable = false, length = 50)
    private RoomStyle roomStyle;

    @Column(name = "is_clean")
    private boolean isClean;

    @NotNull
    @Column(name = "room_size", nullable = false)
    private Long roomSize;

    @ManyToMany
    @JoinTable(
            name = "room_item",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;
    @OneToMany(mappedBy = "room")
    private List<RoomImage> roomImages;

}