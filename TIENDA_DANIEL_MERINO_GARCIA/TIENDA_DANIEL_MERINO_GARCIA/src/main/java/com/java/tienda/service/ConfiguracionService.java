package com.java.tienda.service;

import java.util.ArrayList;

import com.java.tienda.dao.ConfiguracionDao;
import com.java.tienda.model.Configuracion;

public class ConfiguracionService {
	
	public ConfiguracionService() {
		
	}
	
	
	public ArrayList<Configuracion> getConfiguracion(){
		ConfiguracionDao cDao= new ConfiguracionDao();
		ArrayList<Configuracion> confList = cDao.getAll();
		return confList;
	}
	
	
	
}
