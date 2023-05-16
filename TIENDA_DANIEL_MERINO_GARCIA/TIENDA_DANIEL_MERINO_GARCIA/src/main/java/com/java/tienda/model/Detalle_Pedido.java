package com.java.tienda.model;

import java.io.Serializable;

public class Detalle_Pedido implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int pedido_id;
	private int producto_id;
	private int unidades;
	private double preciounidad;
	private double impuesto;
	private double total;
	
	
	public Detalle_Pedido() {
		
	}
	
	public Detalle_Pedido(int id,int pedido_id,int producto_id,int unidades,double preciounidad,double impuesto,double total) {
		this.id=id;
		this.pedido_id=pedido_id;
		this.producto_id=producto_id;
		this.unidades=unidades;
		this.preciounidad=preciounidad;
		this.impuesto=impuesto;
		this.total=total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPedido_int() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public double getPreciounidad() {
		return preciounidad;
	}

	public void setPreciounidad(double preciounidad) {
		this.preciounidad = preciounidad;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
