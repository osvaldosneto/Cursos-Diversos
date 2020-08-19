package com.osvaldo.cursomvc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.osvaldo.cursomvc.services.DbService;

@Configuration
@Profile("test") // ativa somente os beans do test propreties
public class TestConfig {

	@Autowired
	private DbService dbService;

	@Bean
	public boolean instantiateDataBase() throws ParseException {
		dbService.instanciateTestDatabase();
		return true;
	}

}
