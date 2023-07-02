package com.company.hrs.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class Address extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID",nullable = true)
    private City city;

    @Size(max = 50)
    @NotNull
    @Column(name = "ADDRESS_LINE", nullable = false, length = 50)
    private String addressLine;

}