package com.osvaldo.cursomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.osvaldo.cursomvc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Transactional(readOnly = true) //para não consultar todos os campos no banco
	Cliente findByEmail(String email); //procura email automatico - findBy"campo banco de dados
	
}
