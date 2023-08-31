package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.ReportService;
import com.company.hrs.service.dtos.report.requests.PostDateRangeRequest;
import com.company.hrs.service.result.DataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    @PostMapping("recipient/{id}")
    public DataResult<Float> getAmountByRecipient(@PathVariable Long id, @RequestBody PostDateRangeRequest request){
        return reportService.getAmountByRecipient(id,request);
    }
}
