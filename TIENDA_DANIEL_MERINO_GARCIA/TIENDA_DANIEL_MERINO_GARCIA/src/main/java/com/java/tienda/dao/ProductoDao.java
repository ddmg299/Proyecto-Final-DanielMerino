package com.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import com.java.tienda.model.Producto;
import com.java.tienda.configuration.Conexion;


public class ProductoDao implements DAO<Producto>{
	
	
private Connection con;
	

	public ProductoDao(){
		
	}
	
	
	
	@Override
	public Producto get(int id) {
		// TODO Auto-generated method stub
		con = Conexion.getConexion();
		PreparedStatement stmt=null;
		Producto producto = null;
		ResultSet rs= null;
		try {
	       
			stmt = con.prepareStatement("SELECT * FROM producto WHERE id = ?");
	        stmt.setInt(1, id);
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	        	int id_prod = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion= rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int stock = rs.getInt("stock");
                float impuesto =rs.getFloat("impuesto");
                boolean baja = rs.getBoolean("baja");
                String foto= rs.getString("foto");
                int categoria_id= rs.getInt("categoria_id");
	            // Aquí podrías seguir extrayendo los valores de otras columnas de la tabla
                
                producto = new Producto(id, nombre,descripcion,precio,stock,impuesto,baja,foto,categoria_id);
	            
	            
	            System.out.println("PRODUCTO EN EL METODO GET:"+producto.getNombre());
	            
	        }
	    } catch (SQLException e) {
	        // Manejo de excepciones
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (stmt != null) stmt.close();
	            if (con != null) Conexion.desconectar();
	        } catch (SQLException e) {
	            // Manejo de excepciones
	        }
	    }
		return producto;
	}




	
	
	
	@Override
	public ArrayList<Producto> getAll() {
		con = Conexion.getConexion();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			//System.out.println("CREO LA CONEXION");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from producto");
			
			while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion= rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int stock = rs.getInt("stock");
                float impuesto =rs.getFloat("impuesto");
                boolean baja = rs.getBoolean("baja");
                String foto= rs.getString("foto");
                int categoria_id= rs.getInt("categoria_id");
                
                Producto producto = new Producto(id, nombre,descripcion,precio,stock,impuesto,baja,foto,categoria_id);
              //  System.out.println(producto.toString());
              //  System.out.println(producto.getNombre());
                productos.add(producto);
            }
			Conexion.desconectar();
			return productos;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return productos;
	}


	@Override
	public void insert(Producto t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(Producto t) {
		// TODO Auto-generated method stub
		con = Conexion.getConexion();
		try {
			PreparedStatement pstm= con.prepareStatement("UPDATE producto SET nombre = ?,descripcion= ?, precio=?, impuesto= ?, stock= ?, baja= ? WHERE id = ?");
			pstm.setString(1,t.getNombre());
			pstm.setString(2,t.getDescripcion());
			pstm.setDouble(3,t.getPrecio());
			pstm.setDouble(4,t.getImpuesto());
			pstm.setDouble(5,t.getStock());
			pstm.setBoolean(6,t.isBaja());
			pstm.setInt(7,t.getId());
			System.out.println("ACTUALIZO STOCK:"+t.getStock());
			int filas= pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public ArrayList<Producto> getByQuerry(String consulta){
		
		con = Conexion.getConexion();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			//System.out.println("CREO LA CONEXION");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(consulta);
			
			while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion= rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                int stock = rs.getInt("stock");
                float impuesto =rs.getFloat("impuesto");
                boolean baja = rs.getBoolean("baja");
                String foto= rs.getString("foto");
                int categoria_id= rs.getInt("categoria_id");

                
                Producto producto = new Producto(id, nombre,descripcion,precio,stock,impuesto,baja,foto,categoria_id);

                productos.add(producto);
            }
			Conexion.desconectar();
			return productos;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return productos;
	}
	
	
	



	
	

}
