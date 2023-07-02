package com.company.hrs.entities;

import com.company.hrs.enums.AccountStatus;
import com.company.hrs.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PERSON")
public class Person extends BaseEntity{


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private Address address;


    @OneToOne(fetch = FetchType.LAZY)
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
    private String gender;

    @Size(max = 50)
    @Column(name = "ACCOUNT_STATUS", length = 50)
    private String accountStatus = "ACTIVE";

    @Column(name = "IMAGE")
    private byte[] image;

}