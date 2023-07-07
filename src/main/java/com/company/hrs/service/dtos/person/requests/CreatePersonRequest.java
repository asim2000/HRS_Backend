package com.company.hrs.service.dtos.person.requests;

import com.company.hrs.entities.Role;
import com.company.hrs.enums.Gender;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRequest {
    @Column(name = "address_id")
    private Long AddressId;
    @Column(name = "contact_id")
    private Long contactId;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String password;
    private byte[] image;
    private List<Role> roles = new ArrayList<>();
}
