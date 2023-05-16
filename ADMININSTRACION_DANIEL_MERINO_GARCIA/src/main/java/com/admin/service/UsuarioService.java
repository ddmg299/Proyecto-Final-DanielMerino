package com.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Rol;
import com.admin.model.Usuario;
import com.admin.repository.UsuarioRepository;





@Service
public class UsuarioService {
	
	
	@Autowired
	private UsuarioRepository uRep;
	
	
	
	//AÑADIR
	public void addUsuario(Usuario u) {
		uRep.save(u);
	}
	
	//ELIMINAR
	public void delUsuario(int id) {
		Usuario p = getUsuario(id);
		uRep.delete(p);
	}
	
	//ACTUALIZAR
	public void updtUsuario(int id,Rol rol,String email,String clave,String nombre,String apellidos,boolean baja) {
		Usuario u = getUsuario(id);
		u.setId(id);
		u.setRol(rol);
		u.setEmail(email);
		u.setClave(clave);
		u.setNombre(nombre);
		u.setApellidos(apellidos);
		u.setBaja(baja);
		uRep.save(u);
		
	}
	
	
	//BUSCAR POR ID
	public Usuario getUsuario(int id) {
		return uRep.findById(id);
	}
	
	//BUSCAR POR EMAIl
	public Usuario getUsuarioByEmail(String email) {
		return uRep.getByEmail(email);
	}
	
	
	//LISTAR
	public List<Usuario> getUsuarios() {
		return uRep.findAll();
	}
	
	
	
	
	
	
	
	
	
	
	

}
