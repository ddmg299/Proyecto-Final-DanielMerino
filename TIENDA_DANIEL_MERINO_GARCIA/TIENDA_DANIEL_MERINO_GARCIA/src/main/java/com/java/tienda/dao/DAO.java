package com.java.tienda.dao;

import java.util.ArrayList;
import java.util.Optional;

public interface DAO<T> {
	
	//devuelve el objeto obtenido de la base de datos
	T get(int id);
	
	//Insertar un nuevo campo en la tabla correspondiente
	void insert(T t);
	
	//Actualizar campo
	void update(T t);
	
	//Borrar campo
	//void delete(T t);
	
	//Devuelve todos los valores de la tabla
	ArrayList<T> getAll();

}
