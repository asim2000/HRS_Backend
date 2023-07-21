package com.company.hrs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel_service")
public class HotelService extends BaseEntity{
    @ManyToOne()
    @JoinColumn(name = "hotel_id",referencedColumnName = "id")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "id")
    private Service service;
}