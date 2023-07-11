package com.company.hrs.entities;

import com.company.hrs.enums.CreditCardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard extends BaseEntity{
    @Size(max = 50)
    @NotNull
    @Column(name = "credit_card_type", nullable = false, length = 50)
    private CreditCardType creditCardType;

    @Size(max = 25)
    @NotNull
    @Column(name = "card_number", nullable = false, length = 25)
    private String cardNumber;

    @NotNull
    @Column(name = "exp_month", nullable = false)
    private byte expMonth;

    @NotNull
    @Column(name = "exp_year", nullable = false)
    private byte expYear;

    @OneToMany(mappedBy = "creditCard",fetch = FetchType.LAZY)
    private List<Payment> payments;
}