package com.osvaldo.cursomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.cursomvc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
