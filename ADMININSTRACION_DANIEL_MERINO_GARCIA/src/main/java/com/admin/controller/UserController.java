package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.model.Usuario;
import com.admin.service.UsuarioService;

@Controller
@RequestMapping("/User")
public class UserController {
	
	
	
	@Autowired
	private UsuarioService uServ;
	
	
	@GetMapping("NuevoUsuario")
	public String newUser() {
		return "/views/usuarios/register";
	}
	
	
	
	
	
	//Dar de baja a un usuario
	@GetMapping("BajaUsuario")
	public String bajaUser(Model model,@RequestParam String id) {
		uServ.bajaUser(Integer.parseInt(id));
		
		 return "redirect:/Home/Usuarios";
	}
	
	
	//Dar de alta a un usuario
	@GetMapping("AltaUsuario")
	public String altaUser(Model model,@RequestParam String id) {
		uServ.altaUser(Integer.parseInt(id));
		
		 return "redirect:/Home/Usuarios";
	}
	
	
	
	//Editar usuario
	@GetMapping("EditarUsuario")
	public String editUser(Model model, @RequestParam String id) {
		//Usuario u = uServ.getUsuario(id);
		model.addAttribute("id",id);
		
		return "/views/usuarios/editUser";
	}
	
	
	
	
	
	
	
	

}
