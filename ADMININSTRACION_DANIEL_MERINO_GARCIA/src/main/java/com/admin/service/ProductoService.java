package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Categoria;
import com.admin.model.Producto;

import com.admin.repository.ProductoRepository;
@Service
public class ProductoService {
	
	
	@Autowired
	private ProductoRepository prodRep;
	
	
	//AÑADIR
	public void addProducto(Producto p) {
		prodRep.save(p);
	}
	//ELIMINAR
	public void delUsuario(int id) {
		Producto p = getProducto(id);
	}
	
	//ACTUALIZAR PRODUCTO
	public void updtProducto(int id, String nombre, String descripcion, double precio, double impuesto, int stock, boolean baja, String foto,Categoria categoria) {
		Producto p =getProducto(id);
		p.setId(id);
		p.setNombre(nombre);
		p.setDescripcion(descripcion);
		p.setPrecio(precio);
		p.setImpuesto(impuesto);
		p.setStock(stock);
		p.setBaja(baja);
		p.setFoto(foto);
		p.setCategoria(categoria);
		prodRep.save(p);
	}
	
	//BUSCAR POR ID
	public Producto getProducto(int id) {
		return prodRep.findById(id);
	}
	
	//LISTAR
	public List<Producto> getProductos(){
		return prodRep.findAll();
	}
	
	
	
	//Dar de baja usuario
		public void bajaUser(int id){
			Producto p = getProducto(id);
			
			p.setBaja(true);
			prodRep.save(p);
		}
			
			
		//Dar de alta usuario
		public void altaUser(int id){
			Producto p = getProducto(id);
			
			p.setBaja(false);
			prodRep.save(p);
		}
	
	
	
}
