package com.company.hrs.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum AccountStatus {
    ACTIVE(0),
    CLOSED(1),
    CANCELED(2),
    BLACK_LISTED(3);
    public int value;
}
