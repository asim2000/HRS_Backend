package com.company.hrs.service.concretes;

import com.company.hrs.repository.ReportRepository;
import com.company.hrs.service.abstracts.ReportService;
import com.company.hrs.service.dtos.report.requests.PostDateRangeRequest;
import com.company.hrs.service.result.DataResult;
import com.company.hrs.service.result.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    @Override
    public DataResult<Float> getAmountByRecipient(Long id, PostDateRangeRequest request) {
        return new SuccessDataResult<>(reportRepository.getAmountByRecipient(id,request.getStartDate(),request.getEndDate()));
    }
}
