package com.company.hrs.entities;

import com.company.hrs.enums.Position;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee")
public class Employee extends BaseEntity{

    @ManyToOne()
    @JoinColumn(name = "parent_id",referencedColumnName = "id")
    private Employee parent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person person;

    @NotNull
    @Column(name = "position", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Position position;
}