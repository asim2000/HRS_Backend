package com.company.hrs.repository;

import com.company.hrs.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
