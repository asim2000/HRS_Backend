package com.company.hrs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ROLE")
public class Role extends BaseEntity{

    @Size(max = 20)
    @NotNull
    @Column(name = "NAME", nullable = false, length = 20)
    private String name;

}