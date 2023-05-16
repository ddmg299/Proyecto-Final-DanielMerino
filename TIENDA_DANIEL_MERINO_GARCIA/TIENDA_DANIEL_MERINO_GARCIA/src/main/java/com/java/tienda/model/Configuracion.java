package com.java.tienda.model;

import java.io.Serializable;

public class Configuracion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String clave;
	private String valor;
	
	public Configuracion() {
		
	}
	
	public Configuracion(String clave, String valor) {
		this.clave= clave;
		this.valor= valor;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
	
	 

}
