package com.virtusatraining.assignment2;

import com.virtusatraining.assignment2.models.Currency;
import com.virtusatraining.assignment2.repositories.CurrencyRepo;
import com.virtusatraining.assignment2.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class Assignment2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Assignment2Application.class, args);
		CurrencyService currencyService = (CurrencyService) applicationContext.getBean("currencyService", CurrencyService.class);
		Currency americanCurrency = new Currency("Lire","Greece","₤");
		System.out.println(americanCurrency.getCountryName());
		Currency testAdd = currencyService.addCurrency(americanCurrency);
		System.out.println(testAdd.getCurrencySymbol());


	}

}
