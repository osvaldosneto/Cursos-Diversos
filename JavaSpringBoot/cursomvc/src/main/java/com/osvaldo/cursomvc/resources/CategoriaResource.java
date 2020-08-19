package com.osvaldo.cursomvc.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.osvaldo.cursomvc.domain.Categoria;
import com.osvaldo.cursomvc.dto.CategoriaDTO;
import com.osvaldo.cursomvc.services.CategoriaServico;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaServico catService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Categoria cat = catService.find(id);
		return ResponseEntity.ok().body(cat);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaDTO objDTO) {
		Categoria obj = catService.fromDTO(objDTO);
		obj = catService.insert(obj);
		// salvando o caminho da url da id e encaminhando a url para o caminho
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO, @PathVariable Long id) {
		Categoria obj = catService.fromDTO(objDTO);
		obj.setId(id);
		obj = catService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		catService.delete(id);
		return ResponseEntity.noContent().build();
	}

	// feito com DTO
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> listaCat = catService.findAll();
		// populando lista DTO
		List<CategoriaDTO> listaDTO = new ArrayList<CategoriaDTO>();
		for (Categoria c : listaCat) {
			CategoriaDTO catDTO = new CategoriaDTO(c);
			listaDTO.add(catDTO);
		}
		return ResponseEntity.ok().body(listaDTO);
	}

	// feito com DTO e paginação recebendo como parãmetros
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		// convertendo objetos em dto
		Page<Categoria> list = catService.findPage(page, linesPerPage, orderBy, direction);
		Page<CategoriaDTO> listDto = list.map(obj -> new CategoriaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
