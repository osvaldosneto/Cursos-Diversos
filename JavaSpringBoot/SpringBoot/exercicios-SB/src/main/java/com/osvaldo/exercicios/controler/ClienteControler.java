package com.osvaldo.exercicios.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osvaldo.exercicios.models.entity.Cliente;

@RestController
public class ClienteControler {
	
	@GetMapping(path = "/clientes/qualquer")
	public Cliente obterCliente() {
		return new Cliente(28, "Pedro", "123.456.789-98");
	}
	
	//passando parametros por url
	@GetMapping("/{id}")
	public Cliente obterCliente(@PathVariable int id) {
		return new Cliente(id, "Maria", "987.445.434-09");
	}
	
	//passando como parametro na query
	@GetMapping
	public Cliente obterCliente2(
			@RequestParam (name = "id") int id) {
		return new Cliente(id, "João", "987.445.434-09");
	}

}
