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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credit_card_id",referencedColumnName = "id")
    private CreditCard creditCard;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id",referencedColumnName = "id",nullable = false)
    private Booking booking;

    @NotNull
    @Column(name = "payment_status", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Float amount;

}