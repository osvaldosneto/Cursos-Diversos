package com.osvaldo.cursomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.cursomvc.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


}
