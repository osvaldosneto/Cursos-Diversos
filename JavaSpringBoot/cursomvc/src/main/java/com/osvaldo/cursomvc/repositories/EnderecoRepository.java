package com.osvaldo.cursomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.cursomvc.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
