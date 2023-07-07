package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role extends BaseEntity{

    @Size(max = 20)
    @NotNull
    @NotEmpty
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<Person> persons = new ArrayList<>();

}