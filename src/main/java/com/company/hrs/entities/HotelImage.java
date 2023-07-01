package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "HOTEL_IMAGE")
public class HotelImage extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private Hotel hotel;

    @NotNull
    @Column(name = "IMAGE", nullable = false)
    private byte[] image;

}