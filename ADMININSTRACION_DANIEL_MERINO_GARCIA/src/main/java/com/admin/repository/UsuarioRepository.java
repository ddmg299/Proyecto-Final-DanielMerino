package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.admin.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	Usuario getByEmail(String email);
	Usuario findById(int id);
	
	
	
	@Query("SELECT u from Usuario u JOIN u.rol r where (r.id = '2' or r.id = '3') and u.email = ?1")
	Usuario getUserByEmailAndRol(String email);
	
}
