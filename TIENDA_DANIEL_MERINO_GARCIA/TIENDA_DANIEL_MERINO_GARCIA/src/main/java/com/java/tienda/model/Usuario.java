package com.java.tienda.model;

import java.io.Serializable;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int rol_id;
	private String email;
	private String clave;
	private String nombre;
	private String apellidos;
	private boolean baja;
	
	
	public Usuario() {
		
	}
	
	public Usuario(int id, int rol_id, String email, String clave, String nombre, String apellidos, boolean baja) {
		super();
		this.id = id;
		this.rol_id = rol_id;
		this.email = email;
		this.clave =clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.baja = baja;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRol_id() {
		return rol_id;
	}


	public void setRol_id(int rol_id) {
		this.rol_id = rol_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


//	public String getClave() {
//		return clave;
//	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public boolean isBaja() {
		return baja;
	}


	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	public static String encriptarPass(String pass) {
		StandardPBEStringEncryptor s = new StandardPBEStringEncryptor(); 
		s.setPassword("contrasena");
		String encriptada = s.encrypt(pass);
		return encriptada;
	}
	
	
	public static String desencriptarPass(String pass) {
		StandardPBEStringEncryptor s = new StandardPBEStringEncryptor(); 
		s.setPassword("contrasena");
		String desencriptada = s.decrypt(pass);
		return desencriptada;
	}
	
	
	public String getClave() {
		return clave;
		
	}
	public String getEncryptedClave() {
		return clave;
		
	}
	
	

}
