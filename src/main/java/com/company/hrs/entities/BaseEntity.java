package com.company.hrs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GenericGenerator(name = "db-uuid", strategy = "guid")
    @GeneratedValue(generator = "db-uuid")
    private String id;
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "UPDATED_DATE")
    private LocalDate updatedDate;

    @Column(name = "ACTIVE")
    private Long active = 1L;
}
