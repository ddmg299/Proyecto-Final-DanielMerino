package com.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.java.tienda.configuration.Conexion;
import com.java.tienda.model.Configuracion;
import com.java.tienda.model.Producto;
import com.java.tienda.model.Usuario;

public class ConfiguracionDao implements DAO<Configuracion>{

	
	private Connection con;
	
	@Override
	public Configuracion get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Configuracion t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Configuracion t) {
		// TODO Auto-generated method stub
		System.out.println("Actualizo Usuario en el Dao");
		con = Conexion.getConexion();
		try {
			PreparedStatement pstm= con.prepareStatement("UPDATE `configuracion` SET `valor`=? WHERE clave='Número Factura'");
			pstm.setString(1,t.getValor());
			
			int filas= pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
		public void updateNumFactura(Configuracion t) {
			// TODO Auto-generated method stub
			System.out.println("Actualizo numero de factura en el Dao");
			con = Conexion.getConexion();
			try {
				PreparedStatement pstm= con.prepareStatement("UPDATE `configuracion` SET `valor`=? WHERE clave='Número Factura'");
				pstm.setString(1,t.getValor());
				
				int filas= pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
		
		
		
	}

	@Override
	public ArrayList<Configuracion> getAll() {
		con = Conexion.getConexion();
		ArrayList<Configuracion> config = new ArrayList<Configuracion>();
		try {
			//System.out.println("CREO LA CONEXION");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from configuracion");
			
			while (rs.next()) {                
                String clave = rs.getString("clave");
                String valor= rs.getString("valor");                               
                Configuracion conf = new Configuracion(clave,valor);
                config.add(conf);
            }
			Conexion.desconectar();
			return config;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return config;
	}
	
	
	public Configuracion getNumFactura() {
		con = Conexion.getConexion();
		Configuracion conf = new Configuracion();
		try {
			//System.out.println("CREO LA CONEXION");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select valor from configuracion WHERE clave='Número Factura'");
			
			if(rs.next()) {                
                
                String valor= rs.getString("valor");                               
               
                conf.setClave("Número factura");
                conf.setValor(valor);
                
            }
			Conexion.desconectar();
			return conf;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return conf;
		
	}

}
