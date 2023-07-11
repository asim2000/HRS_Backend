package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "room_image")
public class RoomImage extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id",referencedColumnName = "id", nullable = false)
    private Room room;

    @NotNull
    @Column(name = "image", nullable = false)
    @Lob
    private byte[] image;

}