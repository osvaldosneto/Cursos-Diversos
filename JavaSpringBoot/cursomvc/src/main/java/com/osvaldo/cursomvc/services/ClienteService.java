package com.osvaldo.cursomvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osvaldo.cursomvc.domain.Cidade;
import com.osvaldo.cursomvc.domain.Cliente;
import com.osvaldo.cursomvc.domain.Endereco;
import com.osvaldo.cursomvc.domain.enums.TipoCliente;
import com.osvaldo.cursomvc.dto.ClienteDTO;
import com.osvaldo.cursomvc.dto.ClienteNewDTO;
import com.osvaldo.cursomvc.repositories.ClienteRepository;
import com.osvaldo.cursomvc.repositories.EnderecoRepository;
import com.osvaldo.cursomvc.services.exceptions.DataIntegrityException;
import com.osvaldo.cursomvc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;
	
	@Autowired
	EnderecoRepository endRepo;

	public Cliente find(Long id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente fromDTO(@Valid ClienteDTO objDTO) {
		Cliente cliente = new Cliente();
		cliente.setId(objDTO.getId());
		cliente.setNome(objDTO.getNome());
		cliente.setEmail(objDTO.getEmail());
		return cliente;
	}

	public Cliente fromDTO(@Valid ClienteNewDTO objNewDTO) {

		// cliente
		Cliente cliente = new Cliente();
		cliente.setNome(objNewDTO.getNome());
		cliente.setEmail(objNewDTO.getEmail());
		cliente.setCpfouCnpj(objNewDTO.getCpfouCnpj());
		cliente.setTipo(TipoCliente.toEnum(objNewDTO.getTipo()));

		// cidade
		Cidade cidade = new Cidade();
		cidade.setId(objNewDTO.getCidadeId());

		// endereço
		Endereco end = new Endereco();
		end.setBairro(objNewDTO.getBairro());
		end.setCep(objNewDTO.getCep());
		end.setLogradouro(objNewDTO.getLogradouro());
		end.setNumero(objNewDTO.getNumero());
		end.setComplemento(objNewDTO.getComplemento());
		end.setCliente(cliente);
		end.setCidade(cidade);
		cliente.getEnderecos().add(end);
		cliente.getTelefones().add(objNewDTO.getTelefone1());

		// telefone
		if (objNewDTO.getTelefone2() != null) {
			cliente.getTelefones().add(objNewDTO.getTelefone2());
		}
		if (objNewDTO.getTelefone3() != null) {
			cliente.getTelefones().add(objNewDTO.getTelefone3());
		}

		return cliente;
	}

	@Transactional // garantir que vai salvar clientes e endereços
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		endRepo.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente updateCliente = find(obj.getId());
		updateCliente.setNome(obj.getNome());
		updateCliente.setEmail(obj.getEmail());
		return repo.save(updateCliente);
	}

	public void delete(Long id) {
		find(id);
		// tratamento de erro
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			// lancando exceção personalizada
			// criar classe e inserir função no resouseexception
			throw new DataIntegrityException(
					"Não é possível exclir o cliente, verifique se existe dependencia em anexo.");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
