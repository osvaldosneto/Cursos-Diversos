package com.osvaldo.cursomvc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osvaldo.cursomvc.domain.Estado;
import com.osvaldo.cursomvc.repositories.EstadoRepository;
import com.osvaldo.cursomvc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoServico {
	
	@Autowired
	EstadoRepository repo;
	
	public Estado find(Long id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}

}
