package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.admin.model.Detalle;
import com.admin.model.Usuario;

public interface DetalleRepository extends JpaRepository<Detalle,Integer>{
	
	
	Detalle findById(int id);
	
	//BUSCAR POR PEDIDO_ID
	@Query("SELECT u from Detalle u JOIN u.pedido p where p.id= ?1 ")
	List<Detalle> listByPedidoId(int pedido_id);

}
