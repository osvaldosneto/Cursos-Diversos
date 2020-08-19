package com.osvaldo.cursomvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.osvaldo.cursomvc.domain.Categoria;
import com.osvaldo.cursomvc.domain.Produto;
import com.osvaldo.cursomvc.repositories.CategoriaRepository;
import com.osvaldo.cursomvc.repositories.ProdutoRepository;
import com.osvaldo.cursomvc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoServico {

	@Autowired
	ProdutoRepository repo;
	
	@Autowired
	CategoriaRepository catRepo;

	public Produto find(Long id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	// operação de seearch
	public Page<Produto> search(String nome, List<Long> ids, Integer page, Integer linesPerPage, 
			String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = catRepo.findAllById(ids);
		//metodo do repositorio criado
		return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}

}
