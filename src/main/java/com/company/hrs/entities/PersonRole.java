package com.company.hrs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person_role")
public class PersonRole extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id",nullable = false)
    private Person person;
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id",nullable = false)
    private Role role;
}
