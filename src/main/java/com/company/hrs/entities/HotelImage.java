package com.company.hrs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "hotel_image")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","hotel"})
public class HotelImage extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @NotNull
    @Column(name = "path", nullable = false)
    private String path;

}