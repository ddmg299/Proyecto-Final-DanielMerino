package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.admin.model.Configuracion;
import com.admin.repository.ConfiguracionRepository;

public class ConfiguracionService {
	
	
	@Autowired
	private ConfiguracionRepository cRep;
	
	
	
	//AÑADIR
	public void addConfiguracion(Configuracion c) {
		cRep.save(c);
	}
	
	//BORRAR
	public void delConfiguracion(String clave) {
		Configuracion c = getConfiguracion(clave);
		cRep.delete(c);
	}
	
	//ACTUALIZAR
	public void updtConfiguracion(String clave,String valor) {
		Configuracion c = getConfiguracion(clave);
		c.setClave(clave);
		c.setValor(valor);
	}
	
	
	//BUSCAR POR CLAVE
	public Configuracion getConfiguracion(String clave) {
		return cRep.findByClave(clave);
	}
	
	
	
	//LISTAR
	public List<Configuracion> getConfiguraciones(){
		return cRep.findAll();
	}

}
