package com.virtusatraining.assignment2;

import com.virtusatraining.assignment2.models.Currency;
import com.virtusatraining.assignment2.services.CurrencyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class Assignment2Application {
	// This is all devoted to testing the blob input functionality of the Currency model
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Assignment2Application.class, args);
		Assignment2Application app = new Assignment2Application();
		CurrencyService currencyService = (CurrencyService) applicationContext.getBean("currencyService", CurrencyService.class);
		Currency americanCurrency = new Currency("Lira","Greece","₤");
		// Trying to include an image file
		String fileName = "images/lira.png";
		System.out.println("trying to get image as stream: " + fileName);
		byte[] currencyImage = null;
		Resource resource = new ClassPathResource(fileName);
		InputStream is = null;
		try {
			is = resource.getInputStream();
			byte[] bdata = FileCopyUtils.copyToByteArray(is);
			currencyImage =bdata;

		} catch (IOException e) {
			e.printStackTrace();
		}
		americanCurrency.setCurrencyImage(currencyImage);
		System.out.println(americanCurrency.getCountryName());
		Currency testAdd = currencyService.addCurrency(americanCurrency);
		System.out.println(testAdd.getCurrencySymbol());


	}

}
