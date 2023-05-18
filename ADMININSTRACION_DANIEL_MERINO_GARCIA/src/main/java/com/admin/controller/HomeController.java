package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.model.Categoria;
import com.admin.model.Pedido;
import com.admin.model.Producto;
import com.admin.model.Rol;
import com.admin.model.Usuario;
import com.admin.service.CategoriaService;
import com.admin.service.DetalleService;
import com.admin.service.PedidoService;
import com.admin.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

import com.admin.service.ProductoService;

@Controller
@RequestMapping("/Home")
public class HomeController {
	
	
	
	@Autowired
	private UsuarioService uServ;

	@Autowired
	private PedidoService pServ;
	
	@Autowired
	private DetalleService dServ;
	
	@Autowired
	private ProductoService prodServ;

	@Autowired
	private CategoriaService cServ;
	
	
	
	@GetMapping("")
	public String goHome(Model model,HttpSession sesion) {
		List<Pedido> pedidosPE= pServ.getPendientesPE();
		model.addAttribute("pendientesPE", pedidosPE);
		List<Pedido> pedidosPC= pServ.getPendientesPC();
		model.addAttribute("pendientesPC", pedidosPC);
		return "/views/home";
	}
	
	
	
	@GetMapping("/Usuarios")
	public String goUsuarios(Model model,HttpSession sesion) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		Rol rol =usuario.getRol();
		int rol_id= rol.getId();
		
		
		if(rol_id==2) {
		
			List<Usuario> usuariosC = uServ.getUsuariosPorRol(1);
			
			model.addAttribute("usuariosC",usuariosC);
			model.addAttribute("rol",rol_id);
		
		}else if(usuario.getRol().getId()==3) {
		
			List<Usuario> usuariosC = uServ.getUsuariosPorRol(1);
			
			
			model.addAttribute("usuariosC",usuariosC);
			List<Usuario> usuariosE = uServ.getUsuariosPorRol(2);
			model.addAttribute("usuariosE",usuariosE);
			model.addAttribute("rol",rol_id);
		
		}
		
		model.addAttribute("nombre","Administración de Usuarios");
		return "/views/usuarios/usuarios";
	}
	
	
	
	
	@GetMapping("/Pedidos")
	public String goPedidos(Model model,HttpSession sesion) {
		List<Pedido> pedidos = pServ.getPedidos();
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		Rol rol =usuario.getRol();
		int rol_id= rol.getId();
		
		model.addAttribute("rol",rol_id);
		model.addAttribute("pedidos",pedidos);
		model.addAttribute("nombre","Administración de Pedidos");
		return "/views/pedidos/pedidos";
	}
	
	
	@GetMapping("/Productos")
	public String goProductos(Model model,HttpSession sesion) {
		List<Producto> productos = prodServ.getProductos();
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		Rol rol =usuario.getRol();
		int rol_id= rol.getId();
		
		model.addAttribute("rol",rol_id);	
		model.addAttribute("productos",productos);
		model.addAttribute("nombre","Administración de Productos");
		return "/views/productos/productos";
	}
	
	
	@GetMapping("/Categorias")
	public String goCategorias(Model model,HttpSession sesion) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		Rol rol =usuario.getRol();
		int rol_id= rol.getId();
		
		model.addAttribute("rol",rol_id);	
		List<Categoria> categorias = cServ.getCategorias();
		model.addAttribute("categorias",categorias);
		model.addAttribute("nombre","Administración de Categorias");
		return "/views/categorias/categorias";
	}
	
	
	@PostMapping("/Pedir")
	public String enviarPedidos(Model model, @RequestParam String id_form,HttpSession sesion) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		Rol rol =usuario.getRol();
		int rol_id= rol.getId();
		
		model.addAttribute("rol",rol_id);
		int id=Integer.parseInt(id_form);
		pServ.enviarPedido(id);

		 return "redirect:/Home";
	}
	
	@PostMapping("/Cancelar")
	public String cancelarPedidos(Model model, @RequestParam String id_form,HttpSession sesion) {
		Usuario usuario = (Usuario) sesion.getAttribute("usuario");
		
		Rol rol =usuario.getRol();
		int rol_id= rol.getId();
		
		model.addAttribute("rol",rol_id);
		int id=Integer.parseInt(id_form);
		pServ.cancelarPedido(id);

		 return "redirect:/Home";
	}

}
