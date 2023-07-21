package com.company.hrs.entities;

import com.company.hrs.enums.RoomStatus;
import com.company.hrs.enums.RoomStyle;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room extends BaseEntity{

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "hotel_id",referencedColumnName = "id",nullable = false)
    private Hotel hotel;

    @Column(name = "room_number")
    @Size(max = 20)
    private String roomNumber;

    @NotNull
    @Column(name = "price_per_night", nullable = false)
    private Float pricePerNight;

    @NotNull
    @Column(name = "floor", nullable = false)
    private Byte floor;

    @NotNull
    @Column(name = "adult_count", nullable = false)
    private Byte adultCount;
    @NotNull
    @Column(name = "childreen_count", nullable = false)
    private Byte childreenCount;

    @Column(name = "room_status")
    @ColumnDefault(value = "0")
    private RoomStatus roomStatus = RoomStatus.AVAILABLE;

    @NotNull
    @Column(name = "twin_bed_count", nullable = false)
    private Byte twinBedCount;

    @NotNull
    @Column(name = "single_bed_count", nullable = false)
    private Byte singleBedCount;

    @Column(name = "is_pet_allowed")
    @NotNull
    private Boolean isPetAllowed;

    @NotNull
    @Column(name = "room_count", nullable = false)
    private Byte roomCount;

    @NotNull
    @Column(name = "shower_count", nullable = false)
    private Byte showerCount;

    @Size(max = 2000)
    @Column(name = "description", length = 2000)
    private String description;

    @NotNull
    @Column(name = "room_style", nullable = false, length = 50)
    private RoomStyle roomStyle;

    @Column(name = "is_clean")
    @ColumnDefault(value = "true")
    private Boolean isClean = true;


    @NotNull
    @Column(name = "room_size", nullable = false)
    private Short roomSize;
}