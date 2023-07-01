package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ROOM_HOUSE_KEEPER")
public class RoomHouseKeeper extends BaseEntity{

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    @NotNull
    @Column(name = "START_DATE_TIME", nullable = false)
    private LocalDate startDateTime;

    @NotNull
    @Column(name = "DURATION", nullable = false)
    private Long duration;

}