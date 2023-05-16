package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.model.Pedido;
import com.admin.model.Usuario;
import com.admin.service.PedidoService;
import com.admin.service.UsuarioService;

@Controller
@RequestMapping("/Home")
public class HomeController {
	
	
	
	@Autowired
	private UsuarioService uServ;
	@Autowired
	private PedidoService pServ;
	
	
	@GetMapping("")
	public String goHome(Model model) {
		List<Pedido> pedidos= pServ.getPendientes();
		model.addAttribute("pendientes", pedidos);
		return "/views/home";
	}
	
	
	
	@GetMapping("/Usuarios")
	public String goUsuarios(Model model) {
		
		List<Usuario> usuarios = uServ.getUsuarios();
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("nombre","Administración de Usuarios");
		return "/views/usuarios/usuarios";
	}
	@GetMapping("/Pedidos")
	public String goPedidos(Model model) {
		model.addAttribute("nombre","Administración de Pedidos");
		return "/views/pedidos/pedidos";
	}
	
	@GetMapping("/Productos")
	public String goProductos(Model model) {
		model.addAttribute("nombre","Administración de Productos");
		return "/views/productos/productos";
	}
	
	@GetMapping("/Categorias")
	public String goCategorias(Model model) {
		model.addAttribute("nombre","Administración de Categorias");
		return "/views/categorias/categorias";
	}

}
