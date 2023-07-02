package com.company.hrs.service.dtos.person.responses;

import com.company.hrs.enums.Gender;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedPersonResponse {
    private String id;
    @Column(name = "ADDRESS_ID")
    private String addressId;
    @Column(name = "CONTACT_ID")
    private String contactId;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String password;
    private byte[] image;
}
