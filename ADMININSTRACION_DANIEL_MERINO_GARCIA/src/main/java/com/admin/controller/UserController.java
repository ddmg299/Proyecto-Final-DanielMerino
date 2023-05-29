package com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.model.Rol;
import com.admin.model.Usuario;
import com.admin.service.RolService;
import com.admin.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/User")
public class UserController {
	
	
	
	@Autowired
	private UsuarioService uServ;
	@Autowired
	private RolService rServ;
	
	
	@GetMapping("NuevoUsuario")
	public String newUser(HttpSession sesion) {
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
	public String editUser(Model model, @RequestParam String id,HttpSession sesion) {
		Usuario u = uServ.getUsuario(Integer.parseInt(id));
		model.addAttribute("usuario",u);
		
		return "/views/usuarios/editUser";
	}
	
	
	//AÑADIR USUARIO
	@PostMapping("AddUser")
	public String addUser(Model model, @RequestParam String nombre, String apellidos, String email, String clave,String clave2) {
		
		
		//Si es nulo el correo no esta en la Base de datos
		//SI el email no esta vacio
		if(email.isEmpty()==false) {
			//Si el nombre no esta vacio
			if(nombre.isEmpty()==false) {
				
				//Si el apellido no esta vacio
				if(apellidos.isEmpty()==false) {
					//SI las claves no estan vacias
					
					if((clave.isEmpty()==false)&&(clave2.isEmpty()==false)) {
				
							
							if(uServ.getEmpleadosByEmail(email)==null) {
								System.out.println("ENtra 1");
								//Si las claves coinciden, entonces se crea el usuario
								
								if(clave.equals(clave2)) {
									System.out.println("ENtra 2");	
									Rol rol = rServ.getRol(2);
									Usuario user = new Usuario(rol,email,Usuario.encriptarPass(clave2),nombre,apellidos,false);
									uServ.addUsuario(user);
									return "redirect:/Home/Usuarios"; 
								}else {
									model.addAttribute("valores", "clave");
									return "/views/usuarios/register";
								}
								
							}else {
								model.addAttribute("valores", "email");
								return "/views/usuarios/register";
							}
							
						
					}else {
						model.addAttribute("valores", "claves1");
						return "/views/usuarios/register";
						
					}
				}else {
					model.addAttribute("valores", "ape");
					return "/views/usuarios/register";
				}
			}else {
				model.addAttribute("valores", "nombre");
				return "/views/usuarios/register";
			}
		}else {
			model.addAttribute("valores", "email2");
			return "/views/usuarios/register";
		}
			
	}
	
	
	
	
	//AÑADIR USUARIO
		@PostMapping("EditUser")
		public String editUser(Model model, @RequestParam String id, String nombre, String apellidos, String email, String clave,String clave2) {
			
			Usuario u = uServ.getUsuario(Integer.parseInt(id));
			//Si es nulo el correo no esta en la Base de datos
			if((uServ.getEmpleadosByEmail(email)==null)||(u.getEmail().equals(email))) {
				System.out.println("ENtra 1");
				//Si las claves coinciden, entonces se crea el usuario
				if((clave.isEmpty()==false)&&(clave2.isEmpty()==false)) {
					if(clave.equals(clave2)) {
						
						if(Usuario.desencriptarPass(u.getClave()).equals(clave2)) {
							
							System.out.println("ENtra 2");	
							
							uServ.updtUsuario(Integer.parseInt(id), u.getRol(), email, clave2, nombre, apellidos, false);
						
							return "redirect:/Home/Usuarios"; 
						}else {
							model.addAttribute("usuario",u);
							model.addAttribute("valores", "clave");
							return "/views/usuarios/editUser";
						}
					}else {
						model.addAttribute("usuario",u);
						model.addAttribute("valores", "clave");
						return "/views/usuarios/editUser";
					}
					
				}else {
					model.addAttribute("usuario",u);
					model.addAttribute("valores", "clave");
					return "/views/usuarios/editUser";
				}
					
			}else {
				model.addAttribute("usuario",u);
				model.addAttribute("valores", "email");
				return "/views/usuarios/editUser";
			}	
		}
	
	
	
	
	
	
	
	

}
