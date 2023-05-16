package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{
	
	Rol findById(int id);
	

}
