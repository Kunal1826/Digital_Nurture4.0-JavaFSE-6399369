package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryNotFoundException;
import com.cognizant.orm_learn.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	//Mendatory handson feature

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	//Additional handson feature


	private static void getAllCountriesTest() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("In");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}

	public static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country c = new Country();
		c.setCode("kn");
		c.setName("Knowhere");
        countryService.addCountry(c);
		Country country = countryService.findCountryByCode("kn");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}

	public static void testUpdateCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
        Country country = countryService.updateCountry("kn","novhere");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}

    public static void testdelete() throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.deleteCountry("kn");
		LOGGER.info("End");
	}




	public static void main(String[] args) throws CountryNotFoundException {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		//Mendatory handson feature

//		testGetAllCountries();

       //additional features

        getAllCountriesTest();
//		 testAddCountry();
//        testUpdateCountry();
//		  testdelete();

	}
}
