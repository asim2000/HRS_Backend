package com.company.hrs.entities;

import com.company.hrs.enums.AccountStatus;
import com.company.hrs.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person extends BaseEntity{
    @OneToOne()
    @JoinColumn(name = "address_id",referencedColumnName = "id", nullable = false)
    private Address address;


    @OneToOne()
    @JoinColumn(name = "contact_id",referencedColumnName = "id", nullable = false)
    private Contact contact;

    @Size(max = 15)
    @NotNull
    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Size(max = 20)
    @NotNull
    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Size(max = 30)
    @NotNull
    @Column(name = "password", nullable = false, length = 30)
    private String password;


    @NotNull
    @Column(name = "gender")
    @Enumerated(value = EnumType.ORDINAL)
    private Gender gender;

    @NotNull
    @Column(name = "account_status",columnDefinition = "TINYINT(4) default 0")
    @Enumerated(value = EnumType.ORDINAL)
    private AccountStatus accountStatus = AccountStatus.ACTIVE;

    @Column(name = "image")
    @Lob
    private byte[] image;
    @OneToMany(mappedBy = "person")
    private List<Review> reviews;
    @ManyToMany()
    @JoinTable(
            name = "person_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "person")
    private List<Booking> bookings;

}