package com.company.hrs.service.dtos.account.requests;

import com.company.hrs.enums.Gender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String surname;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String phone;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private Gender gender;
    private MultipartFile image;
    @NotNull
    @Column(name = "city_id")
    private Long cityId;
    @NotNull
    @NotEmpty
    @Column(name = "address_line")
    private String addressLine;
    @NotNull
    @NotEmpty
    private String password;
    @NotNull
    @NotEmpty
    private String role;
}
