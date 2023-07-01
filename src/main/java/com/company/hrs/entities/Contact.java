package com.company.hrs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "CONTACT")
public class Contact extends BaseEntity{
    @Size(max = 15)
    @NotNull
    @Column(name = "PHONE", nullable = false, length = 15)
    private String phone;

    @Size(max = 50)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;
}