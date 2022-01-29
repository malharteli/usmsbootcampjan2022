package com.example.calendar.repositories;

import com.example.calendar.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, String> {

}
