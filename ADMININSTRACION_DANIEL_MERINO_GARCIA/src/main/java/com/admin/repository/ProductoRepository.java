package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.admin.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	
	Producto findById(int id);

}
