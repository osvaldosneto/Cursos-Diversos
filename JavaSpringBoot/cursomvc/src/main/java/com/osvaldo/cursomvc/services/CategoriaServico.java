package com.osvaldo.cursomvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.osvaldo.cursomvc.domain.Categoria;
import com.osvaldo.cursomvc.dto.CategoriaDTO;
import com.osvaldo.cursomvc.repositories.CategoriaRepository;
import com.osvaldo.cursomvc.services.exceptions.DataIntegrityException;
import com.osvaldo.cursomvc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaServico {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Long id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Categoria update(Categoria obj) {
		Categoria categoria = find(obj.getId());
		categoria.setId(obj.getId());
		categoria.setNome(obj.getNome());
		return repo.save(categoria);
	}

	public void delete(Long id) {
		find(id);
		//tratamento de erro
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException e) {
			//lancando exceção personalizada
			//criar classe e inserir função no resouseexception
			throw new DataIntegrityException("Não é possível exclir a categoria, verifique se existe produto anexo.");	
		}
		
	}

	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	//retornar somente uma pagina
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDTO) {
		Categoria cat = new Categoria();
		cat.setId(objDTO.getId());
		cat.setNome(objDTO.getNome());
		return cat;
	}
	
	
}
