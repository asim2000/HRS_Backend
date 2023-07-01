package com.company.hrs.entities;

import com.company.hrs.enums.AccountStatus;
import com.company.hrs.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PERSON")
public class Person extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address address;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONTACT_ID", nullable = false)
    private Contact contact;

    @Size(max = 15)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 15)
    private String name;

    @Size(max = 20)
    @NotNull
    @Column(name = "SURNAME", nullable = false, length = 20)
    private String surname;

    @NotNull
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private LocalDate dateOfBirth;

    @Size(max = 30)
    @NotNull
    @Column(name = "PASSWORD", nullable = false, length = 30)
    private String password;

    @Size(max = 50)
    @NotNull
    @Column(name = "GENDER", nullable = false, length = 50)
    private Gender gender;

    @Size(max = 50)
    @NotNull
    @Column(name = "ACCOUNT_STATUS", nullable = false, length = 50)
    private AccountStatus accountStatus;

    @Column(name = "IMAGE")
    private byte[] image;

}