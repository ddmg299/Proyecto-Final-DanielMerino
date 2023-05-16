package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.admin.model.Usuario;
import com.admin.service.UsuarioService;

@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UsuarioService uServ;
	

	
	@RequestMapping("/")
	public String indice(Model model) {
		
		return "index";
	}
	
	
	//Comprobacion del login
	@PostMapping("/Home")
	public String doLogin(Model model, @RequestParam String email, String clave) {
		
		if((email!="")&&(clave!="")) {
			Usuario user = uServ.getUsuarioByEmail(email);
			
			if(email.equals(user.getEmail())) {
				//Email Correcto
				
				if(clave.equals(Usuario.desencriptarPass(user.getClave()))) {
					//Clave Correcta
					
					return "tablas";
				}else {
					model.addAttribute("valores", "clave");
					return "index";
				}
			
			}else {
				model.addAttribute("valores", "email");
				return "index";
			}
		}else {
			model.addAttribute("valores", "todo");
			return "index";
		}
	
		
		
	}
	
}
