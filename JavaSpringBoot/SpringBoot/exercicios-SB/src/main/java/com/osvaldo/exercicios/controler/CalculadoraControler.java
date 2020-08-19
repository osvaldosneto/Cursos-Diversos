package com.osvaldo.exercicios.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraControler {
	
	@GetMapping(path = "/somar/{a}/{b}")
	public Double soma(@PathVariable Double a, @PathVariable Double b) {
		return a + b;
	}
	
	@GetMapping (path = "/subtrair")
	public Double Sub(
			@RequestParam (name = "a") Double a, 
			@RequestParam (name = "b") Double b) {		
		return a - b;
	}

}
