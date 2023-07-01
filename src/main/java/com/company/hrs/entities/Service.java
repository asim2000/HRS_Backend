package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "SERVICE")
public class Service extends BaseEntity{
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "HOTEL_ID", nullable = false)
    private Hotel hotel;

    @Size(max = 50)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @NotNull
    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Size(max = 2000)
    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

}