package com.osvaldo.cursomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.cursomvc.domain.Pagamento;

public interface PagamentoRepository  extends JpaRepository<Pagamento, Long>{

}
