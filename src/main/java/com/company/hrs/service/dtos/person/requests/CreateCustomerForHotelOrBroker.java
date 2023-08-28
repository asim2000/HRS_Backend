package com.company.hrs.service.dtos.person.requests;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCustomerForHotelOrBroker {
    @NotNull
    String email;
    @NotNull
    String name;
    @NotNull
    String surname;
    @NotNull
    String phone;
}
