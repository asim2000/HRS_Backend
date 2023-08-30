package com.company.hrs.service.dtos.report.requests;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDateRangeRequest {
    LocalDate startDate;
    LocalDate endDate;
    public PostDateRangeRequest(LocalDate startDate,LocalDate endDate){
        this.startDate = startDate.plusMonths(1);
        this.endDate = endDate.plusMonths(1);
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate.plusMonths(1);
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate.plusMonths(1);
    }
}
