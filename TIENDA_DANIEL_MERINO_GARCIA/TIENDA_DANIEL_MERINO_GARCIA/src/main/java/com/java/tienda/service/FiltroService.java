package com.java.tienda.service;

import java.util.ArrayList;

import com.java.tienda.dao.ProductoDao;
import com.java.tienda.model.Producto;

public class FiltroService {
	
	
	public FiltroService() {
		
	}
	
	
	public ArrayList<Producto> filtroHome(String[] precios,boolean populares,int idCategoria){
		ProductoDao pdao= new ProductoDao();
		ArrayList<Producto> productos= new ArrayList<Producto>();
		
		StringBuilder sql= new StringBuilder("SELECT * FROM producto");
		
		
		if(precios!=null) {
			if(precios.length==1) {
				sql.append(" where precio >= '"+precios[0]+"'");
			}else if(precios.length==2) {
				sql.append(" where precio between '"+precios[0]+"' and '"+precios[1]+"'");
			}
		}
		
		
//		if(populares==true) {
//			if(sql.toString().contains("where")) {
//				sql.append("");
//			}else {
//				sql.append("");
//			}
//		}
		if(idCategoria!=0) {
			if(sql.toString().contains("where")) {
				sql.append(" and categoria_id='"+idCategoria+"'");
			}else {
				sql.append(" where categoria_id='"+idCategoria+"'");
			}
		}
		
		
		System.out.println(" sql:"+sql);
		
		
		
		
		
		productos= pdao.getByQuerry(sql.toString());
		
		return productos;
	}

}
