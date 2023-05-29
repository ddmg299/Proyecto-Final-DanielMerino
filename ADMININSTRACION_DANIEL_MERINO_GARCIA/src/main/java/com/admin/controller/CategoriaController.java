package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.model.Categoria;
import com.admin.model.Rol;
import com.admin.model.Usuario;
import com.admin.service.CategoriaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/Categoria")
public class CategoriaController {
	
	
	@Autowired
	private CategoriaService cServ;
	
	@GetMapping("NuevaCategoria")
	public String newCategoria() {
		return "/views/categorias/nuevaCategoria";
	}
	
	
	//Dar de baja a un usuario
		@GetMapping("BajaCategoria")
		public String bajaUser(Model model,@RequestParam String id) {
			cServ.bajaCategoria(Integer.parseInt(id));
			
			return "redirect:/Home/Categorias";
		}
		
		//Dar de alta a un usuario
		@GetMapping("AltaCategoria")
		public String altaUser(Model model,@RequestParam String id) {
			cServ.altaCategoria(Integer.parseInt(id));
			
			 return "redirect:/Home/Categorias";
		}
	
	
	
	
	
	
	
	

	
	//AÑADIR USUARIO
		@PostMapping("AddCategoria")
		public String addUser(Model model, @RequestParam String nombre,HttpSession sesion) {
			
			if(nombre!="null") {
				Categoria c= new Categoria();
				c.setNombre(nombre);
				cServ.addCategoria(c);
				return "redirect:/Home/Categorias"; 
			}else {
				model.addAttribute("valores", "vacio");
				return "/views/categorias/nuevaCategoria";
			}
			
			
			
		}

}
