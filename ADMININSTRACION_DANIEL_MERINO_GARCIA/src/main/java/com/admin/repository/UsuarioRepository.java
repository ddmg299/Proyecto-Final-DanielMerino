package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	Usuario getByEmail(String email);
	Usuario findById(int id);
	
	
}
