package com.company.hrs.repository;

import com.company.hrs.entities.Report;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ReportRepository extends JpaRepository<Report,Long> {
    @Query("select sum(r.amount) as amount " +
            "from Report r " +
            "where r.active=0 " +
            "and r.payer.id=:id " +
            "and function('year',r.payingDate)>=function('year',:startDate) " +
            "and function('month',r.payingDate)>=function('month',:startDate)" +
            "and function('year',r.payingDate)<=function('year',:endDate)" +
            "and function('month',r.payingDate)<=function('month',:endDate) ")
    Float getAmountByPayer(Long id, LocalDate startDate,LocalDate endDate);
    @Query("select sum(r.amount) as amount " +
            "from Report r " +
            "where r.active=0 " +
            "and r.recipient.id=:id " +
            "and function('year',r.payingDate)>=function('year',:startDate) " +
            "and function('month',r.payingDate)>=function('month',:startDate)" +
            "and function('year',r.payingDate)<=function('year',:endDate)" +
            "and function('month',r.payingDate)<=function('month',:endDate) ")
    Float getAmountByRecipient(Long id, LocalDate startDate,LocalDate endDate);
}
