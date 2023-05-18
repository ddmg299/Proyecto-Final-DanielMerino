package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.admin.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	
	
	//BUSCAR POR EL EMAIL
	
	Usuario getByEmail(String email);
	//BUSCAR POR ID
	Usuario findById(int id);
	
	
	
	
	
	
	//BUSCAR POR SU ROL
	@Query("SELECT u from Usuario u JOIN u.rol r where r.id= ?1 ")
	List<Usuario> listByRol(int rol_id);
	
	
	@Query("SELECT u from Usuario u JOIN u.rol r where (r.id = '2' or r.id = '3') and u.email = ?1")
	Usuario getUserByEmailAndRol(String email);
	
}
