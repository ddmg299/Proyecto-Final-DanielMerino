package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.Detalle;

public interface DetalleRepository extends JpaRepository<Detalle,Integer>{
	
	
	Detalle findById(int id);

}
