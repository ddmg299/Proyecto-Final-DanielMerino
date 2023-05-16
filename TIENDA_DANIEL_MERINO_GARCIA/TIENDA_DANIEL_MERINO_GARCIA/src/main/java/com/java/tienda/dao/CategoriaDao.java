package com.java.tienda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.tienda.configuration.Conexion;
import com.java.tienda.model.Categoria;
import com.java.tienda.model.Producto;

public class CategoriaDao implements DAO<Categoria>{
	private static Connection con;
	
	
	
	@Override
	public Categoria get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Categoria t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Categoria t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Categoria> getAll() {
		// TODO Auto-generated method stub
		con = Conexion.getConexion();
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		try {
			//System.out.println("CREO LA CONEXION");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from categoria");
			
			while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                
                
                Categoria categoria = new Categoria(id,nombre);
              //  System.out.println(producto.toString());
              //  System.out.println(producto.getNombre());
                categorias.add(categoria);
            }
			Conexion.desconectar();
			return categorias;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return categorias;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
