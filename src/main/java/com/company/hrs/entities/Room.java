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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id",referencedColumnName = "id",nullable = false)
    private Hotel hotel;

    @Column(name = "room_number")
    @Size(max = 20)
    private String roomNumber;

    @NotNull
    @Column(name = "price_per_night", nullable = false)
    private Double pricePerNight;

    @NotNull
    @Column(name = "floor", nullable = false)
    private Long floor;

    @NotNull
    @Column(name = "adult_count", nullable = false)
    private byte adultCount;
    @NotNull
    @Column(name = "childreen_count", nullable = false)
    private byte childreenCount;

    @Size(max = 50)
    @NotNull
    @Column(name = "room_status", nullable = false, length = 50)
    private RoomStatus roomStatus;

    @NotNull
    @Column(name = "twin_bed_count", nullable = false)
    private Long twinBedCount;

    @NotNull
    @Column(name = "single_bed_count", nullable = false)
    private Long singleBedCount;

    @Column(name = "is_pet_allowed")
    @NotNull
    private boolean isPetAllowed;

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

    @Column(name = "is_breakfast_served")
    @NotNull
    private boolean isBreakFastServed;

    @NotNull
    @Column(name = "room_size", nullable = false)
    private Short roomSize;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "room_item",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;
}