package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.Configuracion;

public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer>{
	
	
	Configuracion findByClave(String clave);

}
