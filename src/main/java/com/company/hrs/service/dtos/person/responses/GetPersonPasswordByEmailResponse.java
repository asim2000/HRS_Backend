package com.company.hrs.service.dtos.person.responses;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPersonPasswordByEmailResponse {
    String password;
}
