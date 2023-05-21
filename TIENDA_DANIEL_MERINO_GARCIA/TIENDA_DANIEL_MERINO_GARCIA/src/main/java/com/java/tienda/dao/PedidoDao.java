package com.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.java.tienda.configuration.Conexion;
import com.java.tienda.model.Pedido;
import com.java.tienda.model.Producto;
import com.java.tienda.model.Usuario;

public class PedidoDao implements DAO<Pedido>{
	private static Connection con;
	
	public PedidoDao() {
		
	}

	@Override
	public Pedido get(int id) {
		
		return null;
	}

	@Override
	public void insert(Pedido t) {
		
		
		con = Conexion.getConexion();
		PreparedStatement stmt=null;
		try {
			System.out.println("SE CREA EL PEDIDO");
			stmt=con.prepareStatement("INSERT INTO pedido (usuario_id,fecha,metodopago,numfactura,estado,total) VALUES (?,?,?,?,?,?)");
			
			stmt.setInt(1,t.getUsuario_id());
			stmt.setTimestamp(2, t.getFecha());
			stmt.setString(3,t.getMetodo_pago());
			stmt.setString(4,t.getNum_factura());
			stmt.setString(5,t.getEstado());
			stmt.setDouble(6,t.getTotal());
			
			System.out.println("ID EN LA CONSULTA"+t.getUsuario_id());
			
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				Conexion.desconectar();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		
	}

	@Override
	public ArrayList<Pedido> getAll() {
		
		
		con = Conexion.getConexion();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from pedido");
			
			while (rs.next()) {
                int id = rs.getInt("id");
                int usuario_id = rs.getInt("usuario_id");
                Timestamp fecha = rs.getTimestamp("fecha");
                String metodo_pago= rs.getString("metodo_pago");
                String num_factura= rs.getString("num_factura");
                String estado= rs.getString("estado");
                double total = rs.getDouble("total");                               
                Pedido pedido = new Pedido(id, usuario_id,fecha,metodo_pago,num_factura,estado,total);
                pedidos.add(pedido);
            }
			Conexion.desconectar();
			return pedidos;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return pedidos;
		
	}
	
	
	
	
	
	
	
	public String getMaxNumFactura() {
		String maxNumFactura="";
		
		con = Conexion.getConexion();
		PreparedStatement stmt=null;
		
		ResultSet rs= null;
		try {
	       
			stmt = con.prepareStatement("SELECT numfactura FROM pedido WHERE id = (SELECT MAX(id) FROM pedido)");
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	        	maxNumFactura = rs.getString(1);	            
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
		return maxNumFactura;
		
	}
	
	
	
	
	public int getMaxId() {
		int maxId=0;
		
		
		con = Conexion.getConexion();
		PreparedStatement stmt=null;
		
		ResultSet rs= null;
		try {
	       
			stmt = con.prepareStatement("SELECT MAX(id) FROM pedido");
	        rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	        	maxId = rs.getInt(1);	            
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
		return maxId;
		
		
		
	}

	@Override
	public void update(Pedido t) {
	
		
	}
	
	
	
	
	
	public ArrayList<Pedido> getById(int u_id){

		con = Conexion.getConexion();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			
			PreparedStatement stmt = con.prepareStatement("select * from pedido where usuario_id = ?");
			stmt.setInt(1,u_id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                int id = rs.getInt("id");
                int usuario_id = rs.getInt("usuario_id");
                Timestamp fecha = rs.getTimestamp("fecha");
                System.out.println("Fecha en dao"+fecha);
                String metodo_pago= rs.getString("metodopago");
                String num_factura= rs.getString("numfactura");
                String estado= rs.getString("estado");
                double total = rs.getDouble("total");                               
                Pedido pedido = new Pedido(id, usuario_id,fecha,metodo_pago,num_factura,estado,total);
                pedidos.add(pedido);
            }
			Conexion.desconectar();
			return pedidos;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return pedidos;
	}
	
	
	
	public ArrayList<Pedido> getByDateAndId(String fecha2, int u_id){

		con = Conexion.getConexion();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			
			PreparedStatement stmt = con.prepareStatement("select * from pedido where usuario_id = ? AND DATE(fecha) LIKE ?");
			stmt.setInt(1, u_id);
			stmt.setString(2, fecha2);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                int id = rs.getInt("id");
                int usuario_id = rs.getInt("usuario_id");
                Timestamp fecha = rs.getTimestamp("fecha");
                String metodo_pago= rs.getString("metodopago");
                String num_factura= rs.getString("numfactura");
                String estado= rs.getString("estado");
                double total = rs.getDouble("total");                               
                Pedido pedido = new Pedido(id, usuario_id,fecha,metodo_pago,num_factura,estado,total);
                pedidos.add(pedido);
            }
			Conexion.desconectar();
			return pedidos;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return pedidos;
	}

	
	
	public void cancelaPedido(int p_id) {
		// TODO Auto-generated method stub
				System.out.println("Actualizo Usuario en el Dao");
						con = Conexion.getConexion();
						try {
							PreparedStatement pstm= con.prepareStatement("UPDATE pedido SET estado = 'PC' WHERE id = ?");
							
							pstm.setInt(1,p_id);
							
							int filas= pstm.executeUpdate();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		
	}
	
	

}
