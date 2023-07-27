package com.company.hrs.entities;

import com.company.hrs.enums.CreditCardType;
import jakarta.persistence.*;
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
    @Size(max = 50)
    @NotNull
    @Column(name = "credit_card_type", nullable = false, length = 50)
    private CreditCardType creditCardType;

    @Length(min = 16,max = 16)
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
    @Length(min=3,max=3)
    private Short cvv;
}