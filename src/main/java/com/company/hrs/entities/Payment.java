package com.company.hrs.entities;

import com.company.hrs.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Payment extends BaseEntity{

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_card_id", nullable = false)
    private CreditCard creditCard;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id",nullable = false)
    private Booking booking;

    @Size(max = 50)
    @NotNull
    @Column(name = "payment_status", nullable = false, length = 50)
    private PaymentStatus paymentStatus;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Double amount;

}