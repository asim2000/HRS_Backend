package com.company.hrs.service.abstracts;

import com.company.hrs.service.dtos.report.requests.PostDateRangeRequest;
import com.company.hrs.service.result.DataResult;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public interface ReportService {
    DataResult<Float> getAmountByRecipient(Long id, PostDateRangeRequest request);
}
