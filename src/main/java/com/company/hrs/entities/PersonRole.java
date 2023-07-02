package com.company.hrs.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PERSON_ROLE")
public class PersonRole extends BaseEntity{
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private Role role;
}