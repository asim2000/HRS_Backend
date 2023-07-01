package com.company.hrs.entities;

import com.company.hrs.enums.CreditCardType;
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
@Table(name = "CREDIT_CARD")
public class CreditCard extends BaseEntity{
    @Size(max = 50)
    @NotNull
    @Column(name = "CREDIT_CARD_TYPE", nullable = false, length = 50)
    private CreditCardType creditCardType;

    @Size(max = 25)
    @NotNull
    @Column(name = "CARD_NUMBER", nullable = false, length = 25)
    private String cardNumber;

    @NotNull
    @Column(name = "EXP_MONTH", nullable = false)
    private Long expMonth;

    @NotNull
    @Column(name = "EXP_YEAR", nullable = false)
    private Long expYear;
}