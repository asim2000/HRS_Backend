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
    private Long id;
    @Column(name = "address_id")
    private Long addressId;
    @Column(name = "contact_id")
    private Long contactId;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String gender;
    private String password;
    private byte[] image;
}
