package com.company.hrs.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    ACTIVE(1),DEACTIVE(0);

    public int value;
}
