package com.virtusatraining.assignment2.repositories;

import com.virtusatraining.assignment2.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepo extends JpaRepository<Currency, Long> {
}
