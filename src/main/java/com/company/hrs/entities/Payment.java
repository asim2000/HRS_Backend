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
    @ManyToOne()
    @JoinColumn(name = "credit_card_id", nullable = false)
    private CreditCard creditCard;

    @ManyToOne()
    @JoinColumn(name = "booking_id",nullable = false)
    private Booking booking;

    @NotNull
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Double amount;

}