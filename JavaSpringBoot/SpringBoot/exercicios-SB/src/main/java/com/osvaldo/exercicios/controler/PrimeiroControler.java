package com.osvaldo.exercicios.controler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //anotacion webservice
public class PrimeiroControler {
	
	@RequestMapping(method = RequestMethod.GET, path = "/ola")
	public String ola() {
		return "Olá Spring Boot";
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/ola")
	public String olaPost() {
		return "Olá Spring Boot no post";
	}

}
