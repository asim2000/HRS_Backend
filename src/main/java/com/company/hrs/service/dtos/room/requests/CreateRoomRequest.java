package com.company.hrs.service.dtos.room.requests;

import com.company.hrs.entities.Item;
import com.company.hrs.enums.RoomStatus;
import com.company.hrs.enums.RoomStyle;
import com.company.hrs.service.dtos.item.requests.CreateItemRequest;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomRequest {
    @Column(name = "hotel_id")
    private Integer hotelId;
    @Column(name = "room_number")
    private String roomNumber;
    @NotNull
    @Column(name = "price_per_night", nullable = false)
    private Double pricePerNight;
    @NotNull
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
    private List<CreateItemRequest> items;
}
