package com.osvaldo.cursomvc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osvaldo.cursomvc.domain.Endereco;
import com.osvaldo.cursomvc.repositories.EnderecoRepository;
import com.osvaldo.cursomvc.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository repo;
	
	public Endereco find(Long id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}

}
