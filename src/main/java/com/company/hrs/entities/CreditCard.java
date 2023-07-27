package com.company.hrs.entities;

import com.company.hrs.enums.CreditCardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "credit_card")
public class CreditCard extends BaseEntity{
    @NotNull
    @Column(name = "credit_card_type", nullable = false)
    private CreditCardType creditCardType;
    @NotNull
    @Column(name = "card_number", nullable = false)
    private Long cardNumber;

    @NotNull
    @Column(name = "exp_month", nullable = false)
    private Byte expMonth;

    @NotNull
    @Column(name = "exp_year", nullable = false)
    private Byte expYear;
    @Column(name = "cvc")
    @NotNull
    @Min(100)
    @Max(999)
    private Short cvv;
}