package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "REVIEW")
public class Review extends BaseEntity{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Size(max = 30)
    @NotNull
    @Column(name = "TITLE", nullable = false, length = 30)
    private String title;

    @Size(max = 2000)
    @Column(name = "TEXT", length = 2000)
    private String text;
}