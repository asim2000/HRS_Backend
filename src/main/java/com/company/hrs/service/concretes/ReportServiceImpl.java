package com.company.hrs.service.concretes;

import com.company.hrs.repository.ReportRepository;
import com.company.hrs.service.abstracts.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    @Override
    public Float getAmountByRecipient(Long id, Integer month,Integer year) {
        return reportRepository.getAmountByRecipient(id,month,year);
    }
}
