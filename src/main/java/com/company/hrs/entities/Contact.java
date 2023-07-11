package com.company.hrs.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","hotel","person"})
public class Contact extends BaseEntity{
    @Size(max = 15)
    @NotNull
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @OneToOne(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Hotel hotel;
    @OneToOne(mappedBy = "contact",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Person person;

}