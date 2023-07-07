package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "hotel_image")
public class HotelImage extends BaseEntity{

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @NotNull
    @Column(name = "image", nullable = false)
    @Lob
    private byte[] image;

}