package com.company.hrs.api.controller;

import com.company.hrs.service.abstracts.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    @PostMapping("recipient/{id}")
    public Float getAmountByRecipient(@PathVariable Long id, @RequestParam Integer month,@RequestParam Integer year){
        return reportService.getAmountByRecipient(id,month,year);
    }
}
