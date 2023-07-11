package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "review_image")
public class ReviewImage extends BaseEntity{
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id",referencedColumnName = "id", nullable = false)
    private Review review;

    @Column(name = "image")
    @Lob
    private byte[] image;

}