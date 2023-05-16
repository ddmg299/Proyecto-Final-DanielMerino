package com.java.tienda.service;

import java.util.HashMap;

import com.java.tienda.dao.ProductoDao;
import com.java.tienda.model.Producto;

public class ProductoService {
	
	public ProductoService() {
		
	}
	
	
	
	public HashMap<Integer,Producto> actualizaCarrito(int id, HashMap<Integer,Producto> carrito){
		
		
		HashMap<Integer,Producto> carro=carrito;
		ProductoDao pDao= new ProductoDao();
		
		//int contador=0;
		
		Producto producto= pDao.get(id);
		
		//Comprobar stock, si es 0 no se añade
		
		
		
		if(carrito.containsKey(id)==false) {
			carrito.put(id, producto);	
			producto.masCantidad();
		}else {
			carrito.get(id).masCantidad();
			
		}
		
		return carro;
		
	}
	public float precioTotal(HashMap<Integer,Producto> carrito) {
		float pTotal=0;
		
		for (HashMap.Entry<Integer,Producto> entry:carrito.entrySet()) {
			Integer id = entry.getKey();
			Producto p = entry.getValue();
		
		
			pTotal+=(p.getCantidad()*p.getPrecio());
							
		}  
		return pTotal;
	}
	
	
	
	public void restaStock(HashMap<Integer,Producto> carrito) {
		ProductoDao pDao= new ProductoDao();
		System.out.println("ACTUALIZO STOCK");
		for (HashMap.Entry<Integer,Producto> entry:carrito.entrySet()) {
			
			Producto p = entry.getValue();
			System.out.println("STOCK FINALL :"+p.getStock()+"del producto: "+p.getNombre());
			p.setStock(p.getStock()-p.getCantidad());
			System.out.println("STOCK FINAL :"+p.getStock());
			pDao.update(p);				
		}
		
	}
	
	
	
	public Producto buscaPorId(int producto_id) {
		Producto p = null;
		ProductoDao pdao= new ProductoDao();
		p=pdao.get(producto_id);
		return p;
		
	}
	

}
