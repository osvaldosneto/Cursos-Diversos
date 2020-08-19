package com.osvaldo.cursomvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osvaldo.cursomvc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
