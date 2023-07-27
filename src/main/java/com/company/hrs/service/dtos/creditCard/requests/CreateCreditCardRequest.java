package com.company.hrs.service.dtos.creditCard.requests;

import com.company.hrs.enums.CreditCardType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardRequest {
    @NotNull
    private CreditCardType creditCardType;
    @NotNull
    @Min(3)
    private String nameOnCard;
    private Long cardNumber;
    @NotNull
    private Byte expMonth;
    @NotNull
    private Byte expYear;
    @NotNull
    @Min(100)
    @Max(999)
    private Short cvv;
}
