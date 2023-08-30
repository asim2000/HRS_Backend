package com.company.hrs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "report")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Report extends BaseEntity{
    @ManyToOne()
    @JoinColumn(name = "payer_id",referencedColumnName = "id")
    Person payer;

    @ManyToOne
    @JoinColumn(name = "recipient_id",referencedColumnName = "id")
    Person recipient;
    Float amount;
    Byte month;
    Byte year;
}
