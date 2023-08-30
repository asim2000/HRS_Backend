package com.company.hrs.enums;

import lombok.AllArgsConstructor;

import java.awt.geom.Arc2D;


public enum PerCent {
    HOTEL(14f),BROKER(5f),CUSTOMER_MINIMUM_PAY_PER_CENT(20f);
    public final Float value;
    PerCent(Float value){
        this.value=value;
    }

}
