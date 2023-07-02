package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "CUSTOMER_SERVICE")
public class CustomerService extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @NotNull
    @Column(name = "SERVICE_ID", nullable = false)
    private byte[] serviceId;
}