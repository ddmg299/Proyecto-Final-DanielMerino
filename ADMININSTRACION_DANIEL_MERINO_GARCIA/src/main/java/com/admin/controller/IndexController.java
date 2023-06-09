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

import com.admin.model.Pedido;
import com.admin.model.Usuario;
import com.admin.service.PedidoService;
import com.admin.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private UsuarioService uServ;
	@Autowired
	private PedidoService pServ;
	

	
	@RequestMapping("/")
	public String indice(Model model) {
		
		return "index";
	}
	
	
	//Comprobacion del login
	@PostMapping("/Home")
	public String doLogin(Model model, @RequestParam String email, String clave, HttpSession sesion) {
		
		if((email!="")&&(clave!="")) {
			Usuario user = uServ.getEmpleadosByEmail(email);
			
			if(user!=null) {
				
				if(email.equals(user.getEmail())) {
					//Email Correcto
					
					if(clave.equals(Usuario.desencriptarPass(user.getClave()))) {
						//Clave Correcta
						
						List<Pedido> pedidosPE= pServ.getPendientesPE();
						model.addAttribute("pendientesPE", pedidosPE);
						List<Pedido> pedidosPC= pServ.getPendientesPC();
						model.addAttribute("pendientesPC", pedidosPC);
						sesion.setAttribute("usuario", user);
						
						return "/views/home";
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
		}else {
			model.addAttribute("valores", "todo");
			return "index";
		}
	
		
		
	}
	
}
