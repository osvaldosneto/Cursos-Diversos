package com.osvaldo.cursomvc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osvaldo.cursomvc.domain.Cidade;
import com.osvaldo.cursomvc.repositories.CidadeRepository;
import com.osvaldo.cursomvc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeServico {
	
	@Autowired
	CidadeRepository repo;
	
	public Cidade find(Long id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}

}
