package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "REVIEW_IMAGE")
public class ReviewImage extends BaseEntity{
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REVIEW_ID", nullable = false)
    private Review review;

    @Column(name = "IMAGE")
    private byte[] image;

}