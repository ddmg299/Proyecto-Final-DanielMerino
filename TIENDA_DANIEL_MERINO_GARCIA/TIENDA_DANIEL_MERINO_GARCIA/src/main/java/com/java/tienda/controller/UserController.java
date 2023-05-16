package com.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tienda.model.Pedido;
import com.java.tienda.model.Producto;
import com.java.tienda.model.Usuario;
import com.java.tienda.service.PedidoService;
import com.java.tienda.service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getParameter("dir").equals("login")) {
			
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		
		}else if(request.getParameter("dir").equals("register")) {
			
			request.getRequestDispatcher("views/register.jsp").forward(request, response);	
		
		}else if(request.getParameter("dir").equals("EditarDatos")) {
			
			request.getRequestDispatcher("views/UserView.jsp").forward(request, response);	
		
		}else if(request.getParameter("dir").equals("Historial")) {
			
			PedidoService pService = new  PedidoService();
			ArrayList<Pedido> pedidos = pService.getPedidos(((Usuario) request.getSession().getAttribute("usuario")).getId()); 
			
			System.out.println("PEDIDOS"+pedidos);
			
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("views/historial.jsp").forward(request, response);	
			
		}else if(request.getParameter("dir").equals("CSesion")) {
			request.getSession(false).invalidate();
			response.sendRedirect(request.getContextPath());
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		if(request.getParameter("login")!=null) {

			String email= request.getParameter("email");
			String pass= request.getParameter("password");
			UserService uService = new UserService();
			Usuario usuario=uService.userLogin(email);
			
			boolean correcto=false;
			if(usuario!=null) {
				correcto= uService.validateUser(usuario,email,pass);
			}
			
			if(correcto==true) {
				
				//Guardo el objeto usuario
				request.getSession(false).setAttribute("usuario",usuario);

				
				
				response.sendRedirect(request.getContextPath());
			
			}else {
			
				request.setAttribute("loged", false);
				request.getRequestDispatcher("views/login.jsp").forward(request, response);
			
			}

			
		}else if(request.getParameter("register")!=null) {
			
			String nombre=request.getParameter("nombre");
			String apellidos=request.getParameter("apellidos");
			String email=request.getParameter("email");
			String pass=request.getParameter("password");
			
			String passC=request.getParameter("passwordC");
			
			UserService uService = new UserService();
			Usuario usuario=uService.userRegister(email);
			
			
			//Si es distinto de null entonces el usuario esta en la BBDD
			//si el email se encuentra en la base de datos se vuelve al registro y se avisa
			if(usuario!=null) {
				request.setAttribute("registered", false);
				request.getRequestDispatcher("views/register.jsp").forward(request, response);
				
				//Si no esta en la base de datos se comprueban las contraseñas escritas por el
			}else {

				//Si las contraseñas coinciden se registra en la base de datos
				if(pass.equals(passC)){
					usuario=uService.registraUser(nombre,apellidos,email,pass);
					
					//Guardo el objeto usuario
					request.getSession(false).setAttribute("usuario",usuario);
								
					
					response.sendRedirect(request.getContextPath());
		
					//si no coinciden se vuelve al registro y se avisa
				}else {
					request.setAttribute("passwords", false);
					request.getRequestDispatcher("views/register.jsp").forward(request, response);
				}
				
			}
	
		}else if(request.getParameter("CDatos")!=null) {
			
			System.out.println("Cambio de datos");
			UserService uService = new UserService();
			
			String nuevoNombre= request.getParameter("nombre");
			String nuevoApellidos = request.getParameter("apellidos");
			String nuevoEmail = request.getParameter("email");
			String nuevoPass = request.getParameter("password");
			String nuevoPassC = request.getParameter("passwordC");
			
			System.out.println("email:"+((Usuario) request.getSession(false).getAttribute("usuario")).getEmail());
			
			if(nuevoEmail.equals(((Usuario) request.getSession(false).getAttribute("usuario")).getEmail())) {
				
				//Los correos coinciden, entonces cambio los datos en el usuario y hago el update 
				Usuario user = uService.userLogin(((Usuario) request.getSession(false).getAttribute("usuario")).getEmail());
				System.out.println("El email no se ha cambiado");
				user.setNombre(nuevoNombre);
				user.setApellidos(nuevoApellidos);
				
				if(nuevoPass.equals(nuevoPassC)) {
					user.setClave(nuevoPassC);
					uService.updateUser(user);
					response.sendRedirect(request.getContextPath());
				}else {
					//Si las contraseñas no coinciden, se vuelve a la vista del formulario
					request.setAttribute("passwords", false);
					request.getRequestDispatcher("views/UserView.jsp").forward(request, response);
				}
				
			}else {
				
				//Busco el usuario en la BBDD
				Usuario user = uService.userLogin(nuevoEmail);
				
				if(user!=null) {
					System.out.println("El email esta repetido en la BBDD");
					//Si es distinto de null entonces esta en la bbdd y no es el usuario que esta en la sesion, por lo que no lo puedo actualizar
					request.setAttribute("registered", false);
					request.getRequestDispatcher("views/UserView.jsp").forward(request, response);
				}else {
					System.out.println("el email se ha cambiado");

					user = ((Usuario) request.getSession(false).getAttribute("usuario"));
					user.setNombre(nuevoNombre);
					user.setApellidos(nuevoApellidos);
					user.setEmail(nuevoEmail);
					
				
					if(nuevoPass.equals(nuevoPassC)) {
						user.setClave(nuevoPassC);
						uService.updateUser(user);
						response.sendRedirect(request.getContextPath());
					}else {
						//Si las contraseñas no coinciden, se vuelve a la vista del formulario
						request.setAttribute("passwords", false);
						request.getRequestDispatcher("views/UserView.jsp").forward(request, response);
					}
				}
			}
			
			
			

			
		}
	}

}
