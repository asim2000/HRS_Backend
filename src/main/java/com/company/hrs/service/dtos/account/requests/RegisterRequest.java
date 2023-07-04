package com.company.hrs.service.dtos.account.requests;

import com.company.hrs.enums.Gender;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String gender;
    private byte[] image;
    @Column(name = "CITY_ID")
    private String cityId;
    @Column(name = "ADDRESS_LINE")
    private String addressLine;
    private String password;
    private String role;
}
