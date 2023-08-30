package com.company.hrs.service.abstracts;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public interface ReportService {
    Float getAmountByRecipient(Long id, Integer month,Integer year);
}
