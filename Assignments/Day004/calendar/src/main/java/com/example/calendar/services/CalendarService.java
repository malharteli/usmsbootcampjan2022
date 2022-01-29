package com.example.calendar.services;

import com.example.calendar.models.Calendar;
import com.example.calendar.models.Country;
import com.example.calendar.repositories.CalendarRepo;
import com.example.calendar.repositories.CountryRepo;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CalendarService implements Serializable {
    @Autowired
    private CalendarRepo calendarRepo;
    @Autowired
    private CountryRepo countryRepo;

    // insert

    public Calendar addCalendar(Calendar calendar) {
        return this.calendarRepo.save(calendar);
    }

    // update
    @CachePut(value="Calendar", key="$calendarId")
    public Calendar updateCalendar(long calendarId, Calendar calendar) {
        Calendar calendarObj = this.getCalendarById(calendarId);
        if (calendarObj != null) {

        }
        return this.calendarRepo.save(calendar);
    }

    public Country addCountry(Country country) {return this.countryRepo.save(country);}

    // List all
    @Cacheable(value="Calendar")
    public List<Calendar> getAllCalendar() {
        return this.calendarRepo.findAll();
    }
    @Cacheable(value="Calendar", key="#calendarId")
    public Calendar getCalendarById(long calendarId) {
        return this.calendarRepo.findById(calendarId).orElse(null);
    }
    @Cacheable(value="Country", key="#countryCode")
    public Country getCountryByCode(String countryCode){
        return this.countryRepo.getById(countryCode);
    }

    @CacheEvict(value="Calendar", key="#calendarId")
    public boolean deleteCalendarById(long calendarId) {
        this.calendarRepo.deleteById(calendarId);
        return (this.getCalendarById(calendarId) == null);
    }
}
