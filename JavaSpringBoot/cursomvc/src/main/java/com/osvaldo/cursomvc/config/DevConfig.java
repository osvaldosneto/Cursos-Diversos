package com.osvaldo.cursomvc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.osvaldo.cursomvc.services.DbService;

@Configuration
@Profile("dev") // ativa somente os beans do test propreties
public class DevConfig {

	@Autowired
	private DbService dbService;
	
	//capturando o valor da chave em propreties
	@Value("$(spring.jpa.hibernate.ddl-auto)")
	private String strategy;

	@Bean
	public boolean instantiateDataBase() throws ParseException {
		//condições de alimentar o banco de dados
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instanciateTestDatabase();
		return true;
	}

}
