package com.osvaldo.exercicios.models.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.osvaldo.exercicios.models.entity.Produto;

public interface ProdutoRepository  extends CrudRepository<Produto, Integer> {

}
