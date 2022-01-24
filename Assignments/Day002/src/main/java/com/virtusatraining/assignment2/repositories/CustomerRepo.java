package com.virtusatraining.assignment2.repositories;

import com.virtusatraining.assignment2.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
