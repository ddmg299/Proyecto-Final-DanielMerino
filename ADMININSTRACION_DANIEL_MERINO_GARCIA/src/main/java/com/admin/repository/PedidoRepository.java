package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.admin.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	
	Pedido findById(int id);
	
	
	@Query("Select u from Pedido u where estado='PE'")
	List<Pedido> getPedidosPE();
	
}
