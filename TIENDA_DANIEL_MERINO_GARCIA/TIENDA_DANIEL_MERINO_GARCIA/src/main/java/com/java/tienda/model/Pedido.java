package com.java.tienda.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Pedido  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int usuario_id;
	private Timestamp fecha;
	private String metodo_pago;
	private String num_factura;
	private String estado;
	private double total;
	
	
	public Pedido() {
		
	}
	
	public Pedido(int id,int usuario_id,Timestamp fecha,String metodo_pago,String num_factura,String estado,double total) {
		this.id=id;
		this.usuario_id=usuario_id;
		this.fecha=fecha;
		this.metodo_pago=metodo_pago;
		this.num_factura=num_factura;
		this.estado= estado;
		this.total=total;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public String getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}
	
	
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
