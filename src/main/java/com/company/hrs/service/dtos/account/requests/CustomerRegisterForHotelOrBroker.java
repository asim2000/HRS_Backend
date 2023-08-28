package com.company.hrs.service.dtos.account.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRegisterForHotelOrBroker {
    String name;
    String surname;
    String email;
    String phone;
}
