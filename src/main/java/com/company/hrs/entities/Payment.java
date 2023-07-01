package com.company.hrs.entities;

import com.company.hrs.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PAYMENT")
public class Payment extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CREDIT_CARD_ID", nullable = false)
    private CreditCard creditCard;

    @Size(max = 50)
    @NotNull
    @Column(name = "PAYMENT_STATUS", nullable = false, length = 50)
    private PaymentStatus paymentStatus;

    @NotNull
    @Column(name = "TOTAL", nullable = false)
    private Double total;

}