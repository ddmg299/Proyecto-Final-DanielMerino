package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Rol;
import com.admin.repository.RolRepository;
@Service
public class RolService {
	
	
	@Autowired
	private RolRepository rRep;
	
	
	
	//AÑADIR
	public void addRol(Rol r) {
		rRep.save(r);
	}
	
	//ELIMINAR
	public void delRol(int id) {
		Rol r = getRol(id);
		rRep.delete(r);
	}
	
	
	//ACTUALIZAR ROL
	public void updtPedido(int id,String rol) {
		Rol r = getRol(id);
		r.setId(id);
		r.setRol(rol);
		rRep.save(r);
	}
	
	//BUSCAR POR ID
	public Rol getRol(int id) {
		return rRep.findById(id);
	}
	
	
	//LISTAR
	public List<Rol> getRoles(){
		return rRep.findAll();
	}
	

}
