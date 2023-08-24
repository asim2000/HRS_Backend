package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "hotel")
public class Hotel extends BaseEntity{
    @OneToOne
    @NotNull
    @JoinColumn(name = "employee_id",referencedColumnName = "id",nullable = false)
    private Employee employee;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id",nullable = false)
    private Address address;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id",referencedColumnName = "id", nullable = false)
    private Contact contact;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "star")
    @NotNull
    private Byte star;
    @Column(name = "rating")
    private Float rating;
    @Column(name = "main_image_name")
    @NotNull
    private String mainImageName;

    @Size(max = 2000)
    @Column(name = "description", length = 2000)
    private String description;

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<HotelImage> images = new ArrayList<>();
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}