package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.admin.model.Categoria;
import com.admin.repository.CategoriaRepository;

public class CategoriaService {
	
	
	@Autowired
	private CategoriaRepository cRep;
	
	
	
	
	
	//AÑADIR
	public void addCategoria(Categoria c) {
		cRep.save(c);
	}
	
	
	//ELIMINAR
	public void delCategoria(int id) {
		Categoria c = getCategoria(id);
		cRep.delete(c);
	}
	
	
	
	//ACTUALIZAR
	public void updtCategoria(int id,String nombre) {
		Categoria c = getCategoria(id);
		c.setId(id);
		c.setNombre(nombre);
	}
	
	
	//BUSCAR POR ID
	public Categoria getCategoria(int id) {
		return cRep.findById(id);
	}
	
	//LISTAR
	public List<Categoria> getCategorias(){
		return cRep.findAll();
	}

}
