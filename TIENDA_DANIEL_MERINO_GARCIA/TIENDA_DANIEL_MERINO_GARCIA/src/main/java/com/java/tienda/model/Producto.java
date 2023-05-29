package com.java.tienda.model;

import java.io.Serializable;

public class Producto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String descripcion;
	private float precio;
	private int stock;
	private float impuesto;
	private boolean baja;
	private int cantidad=0;
	private String foto;
	private int categoria_id;
	public Producto() {
		
	}
	
	public Producto(int id, String nombre, String descripcion, float precio,int stock, float impuesto, boolean baja,String foto,int categoria_id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock=stock;
		this.impuesto = impuesto;
		this.baja = baja;
		this.foto=foto;
		this.categoria_id=categoria_id;
	}
	
	
	
	
	
	
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int num) {
		this.cantidad=num;
	}
	public int masCantidad() {
		return this.cantidad+=1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	public void setFoto(String foto) {
		this.foto=foto;
	}
	
	public String getFoto() {
		return this.foto;
	}
	
	
	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	
	
	
	
	
	
	
	

}
