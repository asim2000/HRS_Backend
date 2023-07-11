package com.company.hrs.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","addresses"})
public class City extends BaseEntity{

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<Address> addresses;

}