package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	
	Categoria findById(int id);

}
