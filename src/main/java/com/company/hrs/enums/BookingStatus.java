package com.company.hrs.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BookingStatus {
    REQUESTED(0),
    PENDING(1),
    CONFIRMED(2),
    CHECKED_IN(3),
    CHECKED_OUT(4),
    CANCELED(5),
    ABONDONED(6);
    public Integer value;
}
