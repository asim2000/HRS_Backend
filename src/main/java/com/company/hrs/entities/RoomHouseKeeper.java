package com.company.hrs.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "room_house_keeper")
public class RoomHouseKeeper extends BaseEntity{


    @OneToOne(mappedBy = "roomHouseKeeper")
    private Employee employee;

    @NotNull
    @Column(name = "start_date_time", nullable = false)
    private LocalDate startDateTime;

    @NotNull
    @Column(name = "duration", nullable = false)
    private Long duration;

}