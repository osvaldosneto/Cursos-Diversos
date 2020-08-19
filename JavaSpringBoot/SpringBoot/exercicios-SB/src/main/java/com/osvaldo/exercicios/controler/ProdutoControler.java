package com.osvaldo.exercicios.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osvaldo.exercicios.models.entity.Produto;
import com.osvaldo.exercicios.models.repositorios.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoControler {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	public Produto novoProduto(@RequestParam String nome,
			@RequestParam Double preco,
			@RequestParam Double desconto) {
		Produto p = new Produto(nome, preco, desconto);
		produtoRepository.save(p);
		return p;
	}
	
	@PostMapping
	public Produto novoProduto(@RequestParam Produto p) {
		produtoRepository.save(p);
		return p;
	}
	
	
	@DeleteMapping
	public void deleteProduto(@RequestParam int id) {
		produtoRepository.deleteById(id);
	}

}
