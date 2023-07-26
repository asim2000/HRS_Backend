package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "review")
public class Review extends BaseEntity{
    @ManyToOne()
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "hotel_id",referencedColumnName = "id")
    private Hotel hotel;
    @Size(max = 30)
    @NotNull
    @Column(name = "title", nullable = false, length = 30)
    private String title;

    @Size(max = 2000)
    @Column(name = "text", length = 2000)
    private String text;
    @OneToMany(mappedBy = "review",fetch = FetchType.LAZY)
    private List<ReviewImage> images;
}