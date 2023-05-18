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
	
	//BUSCAR POR ID DENTRO DE LOS USUARIOS CON LOS ROLES 2 Y 3
	public Usuario getEmpleadosByEmail(String email){
		return uRep.getUserByEmailAndRol(email);
	}
	
	
	
	//BUSCAR POR ROL
	public List<Usuario> getUsuariosPorRol(int rol_id){
		List<Usuario> lista =uRep.listByRol(rol_id);
		System.out.println("LISTA "+lista);
		return lista;
	}
	
	
	//Dar de baja usuario
	public void bajaUser(int id){
		Usuario u = getUsuario(id);
		
		u.setBaja(true);
		uRep.save(u);
	}
		
		
	//Dar de baja usuario
	public void altaUser(int id){
		Usuario u = getUsuario(id);
		
		u.setBaja(false);
		uRep.save(u);
	}
	
	
	
	
	
	
	
	
	
	
	

}
