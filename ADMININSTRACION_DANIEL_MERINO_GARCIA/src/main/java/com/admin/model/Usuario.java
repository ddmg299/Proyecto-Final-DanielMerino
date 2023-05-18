package com.admin.model;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @Column(name = "email")
    private String email;

    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "baja")
    private boolean baja;
    
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
	
	

}
