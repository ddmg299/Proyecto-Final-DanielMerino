package com.java.tienda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.java.tienda.configuration.Conexion;
import com.java.tienda.model.Detalle_Pedido;
import com.java.tienda.model.Pedido;

public class Detalle_PedidoDao implements DAO<Detalle_Pedido>{
	private static Connection con;

	
	
	
	@Override
	public Detalle_Pedido get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Detalle_Pedido t) {
		// TODO Auto-generated method stub
		
		con = Conexion.getConexion();
		PreparedStatement stmt=null;
		try {
			System.out.println("SE CREA EL PEDIDO");
			stmt=con.prepareStatement("INSERT INTO detalle (pedido_id,producto_id,unidades,preciounidad,impuesto,total) VALUES (?,?,?,?,?,?)");
			
			stmt.setInt(1,t.getPedido_int());
			stmt.setInt(2, t.getProducto_id());
			stmt.setInt(3,t.getUnidades());
			stmt.setDouble(4,t.getPreciounidad());
			stmt.setDouble(5,t.getImpuesto());
			stmt.setDouble(6,t.getTotal());
			//System.out.println("ID EN LA CONSULTA"+t.getUsuario_id());
			
			
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
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
	public ArrayList<Detalle_Pedido> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Detalle_Pedido t) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public ArrayList<Detalle_Pedido> getAllById(int p_id){
		
		con = Conexion.getConexion();
		ArrayList<Detalle_Pedido> d_pedidos = new ArrayList<Detalle_Pedido>();
		try {
			
			PreparedStatement stmt = con.prepareStatement("select * from detalle where pedido_id = ?");
			stmt.setInt(1,p_id);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
                int id = rs.getInt("id");
               
                int pedido_id = rs.getInt("pedido_id");
                int producto_id = rs.getInt("producto_id");
                int unidades = rs.getInt("unidades");
                double preciounidad = rs.getDouble("preciounidad");   
                double impuesto = rs.getDouble("impuesto");   
                double total = rs.getDouble("total");                               
                Detalle_Pedido dpedido = new Detalle_Pedido(id, pedido_id, producto_id,unidades,preciounidad,impuesto,total);
                d_pedidos.add(dpedido);
            }
			Conexion.desconectar();
			return d_pedidos;
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			}
		return d_pedidos;
	}

}
