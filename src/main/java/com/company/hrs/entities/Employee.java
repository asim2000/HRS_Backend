package com.company.hrs.entities;

import com.company.hrs.enums.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Employee parent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @Size(max = 50)
    @NotNull
    @Column(name = "POSITION", nullable = false, length = 50)
    private Position position;
}