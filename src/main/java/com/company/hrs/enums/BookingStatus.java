package com.company.hrs.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BookingStatus {
    CONFIRMED(0),
    COMPLETED(1),
    CHECKED_IN(2),
    CHECKED_OUT(3),
    CANCELED(4),
    ABONDONED(5),
    PENDING(6);
    public Integer value;
}
