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

import com.osvaldo.cursomvc.domain.Cliente;
import com.osvaldo.cursomvc.dto.ClienteDTO;
import com.osvaldo.cursomvc.dto.ClienteNewDTO;
import com.osvaldo.cursomvc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	ClienteService cliService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Cliente cliente = cliService.find(id);
		return ResponseEntity.ok().body(cliente);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDTO) {
		Cliente obj = cliService.fromDTO(objDTO);
		obj = cliService.insert(obj);
		// salvando o caminho da url da id e encaminhando a url para o caminho
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Long id) {
		Cliente obj = cliService.fromDTO(objDTO);
		obj.setId(id);
		obj = cliService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		cliService.delete(id);
		return ResponseEntity.noContent().build();
	}

	// feito com DTO
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> listaCli = cliService.findAll();
		// populando lista DTO
		List<ClienteDTO> listaDTO = new ArrayList<ClienteDTO>();
		for (Cliente c : listaCli) {
			ClienteDTO cliDTO = new ClienteDTO(c);
			listaDTO.add(cliDTO);
		}
		return ResponseEntity.ok().body(listaDTO);
	}

	// feito com DTO e paginação recebendo como parãmetros
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		// convertendo objetos em dto
		Page<Cliente> list = cliService.findPage(page, linesPerPage, orderBy, direction);
		Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

}
