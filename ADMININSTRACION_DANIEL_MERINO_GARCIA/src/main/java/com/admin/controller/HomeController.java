package com.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Home")
public class HomeController {
	
	
	
	
	@GetMapping("/Usuarios")
	public String goUsuarios() {
		return "/views/usuarios/usuarios";
	}
	@GetMapping("/Pedidos")
	public String goPedidos() {
		return "/views/usuarios/usuarios";
	}
	
	@GetMapping("/Productos")
	public String goProductos() {
		return "/views/usuarios/usuarios";
	}

}
