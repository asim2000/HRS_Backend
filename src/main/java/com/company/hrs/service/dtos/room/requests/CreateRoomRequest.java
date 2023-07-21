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
import org.springframework.data.domain.Persistable;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomRequest implements Persistable<Long> {
    @Column(name = "hotel_id")
    private Integer hotelId;
    @Column(name = "room_number")
    private String roomNumber;
    @NotNull
    @Column(name = "price_per_night", nullable = false)
    private Float pricePerNight;
    @NotNull
    private Byte floor;
    @NotNull
    @Column(name = "adult_count", nullable = false)
    private Byte adultCount;
    @NotNull
    @Column(name = "childreen_count", nullable = false)
    private Byte childreenCount;
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
    private byte showerCount;

    @Size(max = 2000)
    @Column(name = "description", length = 2000)
    private String description;

    @NotNull
    @Column(name = "room_style", nullable = false, length = 50)
    private RoomStyle roomStyle;

    @NotNull
    @Column(name = "room_size", nullable = false)
    private Short roomSize;
    private List<Long> itemIds;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
