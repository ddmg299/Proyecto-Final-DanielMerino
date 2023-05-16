package com.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.tienda.configuration.Conexion;
import com.java.tienda.model.Producto;
import com.java.tienda.model.Usuario;

public class UsuarioDao implements DAO<Usuario>{
	private static Connection con;

	
	public UsuarioDao(){}
	
	@Override
	public Usuario get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public Usuario getByEmail(String correo) {
		// TODO Auto-generated method stub
				con = Conexion.getConexion();
				PreparedStatement stmt=null;
				Usuario usuario = null;
				ResultSet rs= null;
				try {
			       
					stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND rol_id=1");
			        stmt.setString(1, correo);
			        rs = stmt.executeQuery();
			        
			        if (rs.next()) {
			        	
			        	int id = rs.getInt("id");
		                int id_rol = rs.getInt("rol_id");
		                String email= rs.getString("email");
		                String clave = rs.getString("clave");
		                String nombre = rs.getString("nombre");
		                String apellidos = rs.getString("apellidos");
		                boolean baja = rs.getBoolean("baja");
//		                
			            // Aquí podrías seguir extrayendo los valores de otras columnas de la tabla
			           usuario= new Usuario(id,id_rol,email,clave,nombre,apellidos,baja);
			           
			        }
			    } catch (SQLException e) {
			        // Manejo de excepciones
			    	e.printStackTrace();
			    } finally {
			        try {
			            if (rs != null) rs.close();
			            if (stmt != null) stmt.close();
			            if (con != null) Conexion.desconectar();
			        } catch (SQLException e) {
			            // Manejo de excepciones
			        }
			    }
				return usuario;
		
		
		
	}

	@Override
	public ArrayList<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Usuario t) {
		// TODO Auto-generated method stub
		con = Conexion.getConexion();
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("INSERT INTO usuario (rol_id,email,clave,nombre,apellidos,baja) VALUES (?,?,?,?,?,?)");
			stmt.setInt(1, t.getRol_id());
			stmt.setString(2, t.getEmail());
			//cambiar getClave por el que la inserta encriptada
			stmt.setString(3, Usuario.encriptarPass(t.getClave()));
			stmt.setString(4, t.getNombre());
			stmt.setString(5, t.getApellidos());
			stmt.setBoolean(6, t.isBaja());
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			
		}finally {
			try {
				stmt.close();
				Conexion.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}

	@Override
	public void update(Usuario t) {
		// TODO Auto-generated method stub
		System.out.println("Actualizo Usuario en el Dao");
				con = Conexion.getConexion();
				try {
					PreparedStatement pstm= con.prepareStatement("UPDATE usuario SET email = ?,clave= ?, nombre=?, apellidos= ?, baja= ? WHERE id = ?");
					pstm.setString(1,t.getEmail());
					pstm.setString(2,Usuario.encriptarPass(t.getClave()));
					pstm.setString(3,t.getNombre());
					pstm.setString(4,t.getApellidos());
					pstm.setBoolean(5,t.isBaja());
					pstm.setInt(6,t.getId());
					
					int filas= pstm.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}

}
