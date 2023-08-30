package com.company.hrs.repository;

import com.company.hrs.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ReportRepository extends JpaRepository<Report,Long> {
    @Query("select sum(r.amount) from Report r where r.active=0 and r.payer.id=:id and r.year=:year and r.month=:month")
    Float getAmountByPayer(Long id, Integer month,Integer year);
    @Query("select sum(r.amount) from Report r where r.active=0 and r.recipient.id=:id and r.year=:year and r.month=:month")
    Float getAmountByRecipient(Long id, Integer month,Integer year);
}
