package com.company.hrs.entities;

import com.company.hrs.enums.RoomStatus;
import com.company.hrs.enums.RoomStyle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ROOM")
public class Room extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private Hotel hotel;

    @Column(name = "ROOM_NUMBER")
    private Long roomNumber;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    private Long price;

    @NotNull
    @Column(name = "FLOOR", nullable = false)
    private Long floor;

    @NotNull
    @Column(name = "MAX_PEOPLE_COUNT", nullable = false)
    private Long maxPeopleCount;

    @Size(max = 50)
    @NotNull
    @Column(name = "ROOM_STATUS", nullable = false, length = 50)
    private RoomStatus roomStatus;

    @NotNull
    @Column(name = "PAIR_BED_COUNT", nullable = false)
    private Long pairBedCount;

    @NotNull
    @Column(name = "SINGLE_BED_COUNT", nullable = false)
    private Long singleBedCount;

    @Column(name = "IS_PET")
    private Long isPet;

    @NotNull
    @Column(name = "ROOM_COUNT", nullable = false)
    private Long roomCount;

    @NotNull
    @Column(name = "SHOWER_COUNT", nullable = false)
    private Long showerCount;

    @Size(max = 4000)
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @Size(max = 50)
    @NotNull
    @Column(name = "ROOM_STYLE", nullable = false, length = 50)
    private RoomStyle roomStyle;

    @Column(name = "IS_CLEAN")
    private Long isClean;

    @NotNull
    @Column(name = "ROOM_SIZE", nullable = false)
    private Long roomSize;

}