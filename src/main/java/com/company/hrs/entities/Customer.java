package com.company.hrs.entities;

import com.company.hrs.enums.CustomerType;
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
@Table(name = "CUSTOMER")
public class Customer extends Person{

    @Size(max = 50)
    @NotNull
    @Column(name = "CUSTOMER_TYPE", nullable = false, length = 50)
    private CustomerType customerType;
}