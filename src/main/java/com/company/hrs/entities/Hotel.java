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

    @NotNull
    @Column(name = "rating", nullable = false)
    private byte rating;

    @Size(max = 2000)
    @Column(name = "description", length = 2000)
    private String description;
    @ManyToMany()
    @JoinTable(
            name = "hotel_service",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> services = new ArrayList<>();

    @OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
    private List<HotelImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

}