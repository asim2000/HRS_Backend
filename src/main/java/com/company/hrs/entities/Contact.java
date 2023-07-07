package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "contact")
public class Contact extends BaseEntity{
    @Size(max = 15)
    @NotNull
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Size(max = 50)
    @NotNull
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @OneToOne(mappedBy = "contact")
    private Hotel hotel;
    @OneToOne(mappedBy = "contact")
    private Person person;

}