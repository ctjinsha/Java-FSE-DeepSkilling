package com.cognizant.springlearn.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.model.Country;

@Service
public class CountryService {

    public Country getCountry(String code) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        Country[] countries = {
                context.getBean("country1", Country.class),
                context.getBean("country2", Country.class),
                context.getBean("country3", Country.class),
                context.getBean("country4", Country.class)
        };

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }

        }

        return null;
    }

}