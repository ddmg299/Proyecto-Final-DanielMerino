package com.java.tienda.service;

import com.java.tienda.dao.UsuarioDao;
import com.java.tienda.model.Usuario;

public class UserService {
	
	public UserService() {}
	
	
	public Usuario userLogin(String email) {
		
		UsuarioDao uDao = new UsuarioDao();
		Usuario user= uDao.getByEmail(email);
		
		return user;
		
	}
	
	public boolean validateUser(Usuario user,String email,String pass) {
		boolean valido=false;
		boolean password=false;
		boolean mail=false;
		
		
		if(user.getEmail().equals(email)) {
			mail=true;
		}
		if(Usuario.desencriptarPass(user.getClave()).equals(pass)) {
			password=true;
		}
		
		if((mail==true)&&(password==true)) {
			
			valido=true;
		}
		return valido;
		
	}
	
	
	public void updateUser(Usuario user) {
		System.out.println("Actualizo Usuario en el service");
		UsuarioDao udao= new UsuarioDao();
		udao.update(user);
		
	}
	
	
	
	
	
	
	public Usuario userRegister(String email) {
		UsuarioDao uDao = new UsuarioDao();
		Usuario user= uDao.getByEmail(email);
		
		return user;
		
	}
	
	public Usuario registraUser(String nombre,String apellidos,String email,String pass) {
		Usuario user = new Usuario(0,1,email,pass,nombre,apellidos,false);
		UsuarioDao uDao = new UsuarioDao();
		uDao.insert(user);
		return user;
		
	}
	
//	


}
