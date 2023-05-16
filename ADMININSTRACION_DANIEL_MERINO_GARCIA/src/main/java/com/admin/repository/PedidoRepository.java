package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	Pedido findById(int id);
}
